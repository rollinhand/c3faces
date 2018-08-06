package org.kivio.c3faces.script.property;

import org.apache.commons.lang3.StringUtils;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.*;

public class AxisTest {

    /**
     * Testing right generated script, no script
     */
    @Test
    public void testNoScript() {
        Axis axis = new Axis();
        assertEquals("", axis.getScript());
    }

    /**
     * Testing right generated script, no script after null setter
     */
    @Test
    public void testNoScriptNullSetter() {
        Axis axis = new Axis();
        axis.setRotated(true);
        axis.setRotated(null);
        assertEquals("", axis.getScript());
    }

    /**
     * Testing right generated script, rotated true
     */
    @Test
    public void testScriptRotatedTrue() {
        Axis axis = new Axis();
        axis.setRotated(true);
        assertEquals(StringUtils.deleteWhitespace("axis: { rotated: true }"), StringUtils.deleteWhitespace(axis.getScript()));
    }

    /**
     * Testing right generated script, show X true
     */
    @Test
    public void testScriptShowXTrue() {
        Axis axis = new Axis();
        axis.setShowX(true);
        assertEquals(StringUtils.deleteWhitespace("axis: { x: { show: true } }"), StringUtils.deleteWhitespace(axis.getScript()));
    }

    /**
     * Testing right generated script, combination
     */
    @Test
    public void testScriptCombination() {
        Axis axis = new Axis();
        axis.setShowX(true);
        axis.setShowY(true);
        axis.setRotated(true);
        axis.setTypeX(Axis.Type.INDEXED);

        axis.getScript();
        axis.getScript();

        assertEquals(StringUtils.deleteWhitespace("axis:{rotated:true,x:{show:true,type:'indexed'},y:{show:true}}"), StringUtils.deleteWhitespace(axis.getScript()));
    }

    /**
     * Testing categories for X axis (we do not expect categories inside data)
     */
    @Test
    public void testCategoriesXAxis() {
        Axis axis = new Axis();
        Set<String> categoriesX = new LinkedHashSet<>();
        Collections.addAll(categoriesX, new String[] {"category 1", "category 2", "category 3"});
        axis.setCategoriesX(categoriesX);
        axis.setTypeX(Axis.Type.CATEGORY);

        assertEquals(StringUtils.deleteWhitespace("axis:{x:{type:'category',categories:['category 1', 'category 2', 'category 3']}}"), StringUtils.deleteWhitespace(axis.getScript()));
    }

    /**
     * Testing categories for Y axis (we do not expect categories inside data)
     */
    @Test
    public void testCategoriesYAxis() {
        Axis axis = new Axis();
        Set<String> categoriesY = new LinkedHashSet<>();
        Collections.addAll(categoriesY, new String[] {"category 1", "category 2", "category 3"});
        axis.setCategoriesY(categoriesY);
        axis.setTypeY(Axis.Type.CATEGORY);

        assertEquals(StringUtils.deleteWhitespace("axis:{y:{type:'category',categories:['category 1', 'category 2', 'category 3']}}"), StringUtils.deleteWhitespace(axis.getScript()));
    }

    @Test
    public void testEmptyCategoriesXAxis() {
        Axis axis = new Axis();
        axis.setCategoriesX(null);
        axis.setTypeX(Axis.Type.CATEGORY);

        assertEquals(StringUtils.deleteWhitespace("axis:{x:{type:'category'}}"), StringUtils.deleteWhitespace(axis.getScript()));
    }
}
