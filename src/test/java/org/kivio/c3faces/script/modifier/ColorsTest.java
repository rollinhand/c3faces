package org.kivio.c3faces.script.modifier;

import org.kivio.c3faces.model.C3DataSet;
import org.kivio.c3faces.model.C3ViewDataSet;
import org.kivio.c3faces.script.property.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.kivio.c3faces.style.C3Color;

public class ColorsTest {

    /**
     * Test generated script with listened change.
     */
    @Test
    public void testGetScriptWithChange() {

        Colors colors = new Colors();
        Data data = new Data();
        List<Number> numbers = new ArrayList<>();
        Collections.addAll(numbers, 1, 2, 3, 4, 5);
        C3ViewDataSet c3ViewDataSet = new C3ViewDataSet("Name 1", new C3DataSet(numbers), "#EEAAEE");

        data.addListener(colors);
        data.setDataSets(new LinkedHashSet<>(Arrays.asList(c3ViewDataSet)));

        c3ViewDataSet.setColor(C3Color.GREEN);

        assertEquals(StringUtils.deleteWhitespace("chart.data.colors({" + c3ViewDataSet.getId() + ": '#70ad47'});"), StringUtils.deleteWhitespace(colors.getScript("chart", 500)));
    }
}
