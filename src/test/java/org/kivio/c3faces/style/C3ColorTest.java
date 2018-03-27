package org.kivio.c3faces.style;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class C3ColorTest {

    @Test
    public void testValidHexCodes() {
        try {
            new C3Color("#000");
            new C3Color("#FFFFFF");
            new C3Color("#00aaff");
            new C3Color("#09b");
            C3Color c3Color = new C3Color("#777");
            assertThat(c3Color.getHexCode(), is("#777"));
        } catch (IllegalArgumentException e) {
            fail(e.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidHexCodes() {
        new C3Color("#00");
        new C3Color("000000");
        new C3Color("#AZBB99");
        new C3Color("#AABBCCDD");
        new C3Color("aabbff");
    }

    @Test
    public void testEquals() {
        final C3Color THAT = new C3Color("#000");
        final C3Color OTHER = new C3Color("#000");

        assertEquals(THAT, OTHER);

        Set<C3Color> unique = new HashSet<>(Arrays.asList(THAT, OTHER));
        assertThat(unique.size(), is(1));
    }
}
