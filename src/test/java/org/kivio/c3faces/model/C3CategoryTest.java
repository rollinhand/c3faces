package org.kivio.c3faces.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

public class C3CategoryTest {

    @Test
    public void testConstructorWithArray() {
        final String[] input = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        C3Category c3Category = new C3Category(input);

        assertNotNull(c3Category.getValues());
        assertThat(c3Category.getValues().size(), is(7));

        // Test if ordering is kept
        int index = 0;
        for (String category : c3Category.getValues()) {
            assertThat(category, is(input[index++]));
        }
    }

    @Test
    public void testConstructorWithList() {
        final List<String> inputList = Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");
        C3Category c3Category = new C3Category(inputList);

        assertNotNull(c3Category.getValues());
        assertThat(c3Category.getValues().size(), is(7));

        // Test if ordering is kept
        int index = 0;
        for (String category : c3Category.getValues()) {
            assertThat(category, is(inputList.get(index++)));
        }
    }

    @Test
    public void testWithDuplicates() {
        // input contains list with no numeric ordering
        // that is relevant for the ordering test below
        final String[] input = {"1", "1", "3", "2", "3", "4", "5", "4", "2"};
        C3Category c3Category = new C3Category(input);

        assertNotNull(c3Category.getValues());
        assertThat(c3Category.getValues().size(), is(5));

        // Test if ordering is kept
        Iterator<String> it = c3Category.getValues().iterator();
        if (it.hasNext()) {
            assertThat(it.next(), is("1"));
            assertThat(it.next(), is("3"));
            assertThat(it.next(), is("2"));
            assertThat(it.next(), is("4"));
            assertThat(it.next(), is("5"));
        }
    }
}
