package org.kivio.c3faces.script.property;

import org.kivio.c3faces.constants.ChartType;
import org.kivio.c3faces.model.C3CategorySet;
import org.kivio.c3faces.model.C3DataSet;
import org.kivio.c3faces.model.C3ViewDataSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.kivio.c3faces.script.modifier.Colors;

public class DataTest {

    /**
     * Testing right generated script, no data supplied
     */
    @Test
    public void testScriptEmptyData() {
        Data data = new Data();
        assertEquals(StringUtils.deleteWhitespace("data: {columns: [], selection: {enabled: true, multiple: false}}"), StringUtils.deleteWhitespace(data.getScript()));
    }

    /**
     * Testing right generated script, combination
     */
    @Test
    public void testScriptCombination() {
        Data data = new Data();
        List<Number> numbers = new ArrayList<>();
        Collections.addAll(numbers, 1, 2, 3, 4, 5);
        C3ViewDataSet c3ViewDataSet = new C3ViewDataSet("Name 1", new C3DataSet(numbers), "#EEAAEE");

        data.setChartType(ChartType.STEP.getName());
        data.setDataSets(new LinkedHashSet<>(Arrays.asList(c3ViewDataSet)));
        data.addChild(new Bindto("divId123"));

        data.getScript();
        data.getScript();

        assertEquals(
                StringUtils.deleteWhitespace("data: {bindto: 'divId123', columns: [['" + c3ViewDataSet.getId() + "', 1, 2, 3, 4, 5]], names: {" + c3ViewDataSet.getId() + ": 'Name 1'}, colors: {" + c3ViewDataSet.getId() + ": '#EEAAEE'}, type: 'step', selection: {enabled: true, multiple: false}}"),
                StringUtils.deleteWhitespace(data.getScript()));
    }

    /**
     * Testing data.x
     */
    @Test
    public void testDataX() {
        Data data = new Data();
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numbers2 = Arrays.asList(6, 7, 8, 9, 10);
        List<String> categories = Arrays.asList("cat1", "cat2", "cat3", "cat4", "cat5");

        C3ViewDataSet c3ViewDataSet1 = new C3ViewDataSet("Numbers1", new C3DataSet(numbers1), "#EEAAEE");
        C3ViewDataSet c3ViewDataSet2 = new C3ViewDataSet("Numbers2", new C3DataSet(numbers2), "#000");
        C3ViewDataSet c3ViewDataSet3 = new C3ViewDataSet(new C3CategorySet(categories));

        data.setChartType(ChartType.STEP.getName());
        data.setDataSets(new LinkedHashSet<>(
                Arrays.asList(c3ViewDataSet1, c3ViewDataSet2, c3ViewDataSet3)));

        data.addChild(new XKey(c3ViewDataSet3.getId()));

        data.getScript();

        assertEquals(
                StringUtils.deleteWhitespace("data: {x: '" + c3ViewDataSet3.getId() + "', columns: [['" + c3ViewDataSet1.getId() + "', 1, 2, 3, 4, 5],['" + c3ViewDataSet2.getId() + "', 6, 7, 8, 9, 10],['" + c3ViewDataSet3.getId() + "', 'cat1', 'cat2', 'cat3', 'cat4', 'cat5']], names: {" + c3ViewDataSet1.getId() + ": 'Numbers1', " + c3ViewDataSet2.getId() + ": 'Numbers2'}, colors: {" + c3ViewDataSet1.getId() + ": '#EEAAEE', " + c3ViewDataSet2.getId() + ": '#000'}, type: 'step', selection: {enabled: true, multiple: false}}"),
                StringUtils.deleteWhitespace(data.getScript()));
    }
}
