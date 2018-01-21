/**
 Copyright 2015 Martin Linha

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 **/
package org.kivio.c3faces.script.property;

import org.kivio.c3faces.script.ArrayBlock;
import org.kivio.c3faces.script.ObjectBlock;
import org.kivio.c3faces.script.ValueBlock;
import java.util.ArrayList;
import java.util.List;

/**
 * Through this class is possible to define chart's visual properties, specifically add grids to chart.
 *
 *
 * @see <a href="http://c3js.org/reference.html">http://c3js.org/reference.html</a> for attrs info
 * @author Martin Linha
 */
public class GridProperties extends ObjectBlock {

    public static final String EVENT_XGRID_ADDED = "xGridAdd";
    public static final String EVENT_YGRID_ADDED = "yGridAdd";
    public static final String EVENT_YGRID_REMOVED = "yGridRemove";
    public static final String EVENT_XGRID_REMOVED = "xGridRemove";

    public static String NAME = "grid";

    private List<Grid> additionalXLines = new ArrayList<>();
    private List<Grid> additionalYLines = new ArrayList<>();

    public GridProperties() {
    }

    public GridProperties(List<Grid> additionalXLines, List<Grid> additionalYLines) {
        this.additionalXLines = additionalXLines;
        this.additionalYLines = additionalYLines;
    }

    @Override
    protected void preScriptBuild() {

        ObjectBlock xGrids = new ObjectBlock();
        xGrids.setName("x");
        ArrayBlock xLines = new ArrayBlock();
        xLines.setName("lines");
        for (Grid grid : additionalXLines) {
            xLines.addChild(new ObjectBlock(
                    new ValueBlock("value", grid.getValue()),
                    new ValueBlock("text", grid.getText(), true)));
        }
        xGrids.addChild(xLines);
        addChild(xGrids);

        ObjectBlock wrapper = new ObjectBlock();
        wrapper.setName("y");
        ArrayBlock linesArray = new ArrayBlock();
        linesArray.setName("lines");
        for (Grid grid : additionalYLines) {
            linesArray.addChild(new ObjectBlock(
                    new ValueBlock("value", grid.getValue()),
                    new ValueBlock("text", grid.getText(), true)));
        }
        wrapper.addChild(linesArray);
        addChild(wrapper);
    }

    @Override
    public String getName() {
        return NAME;
    }

    public void addXGrid(Double value, String label) {
        Grid grid = new Grid(value, label);
        fireCumulatible(EVENT_XGRID_ADDED, grid);
        additionalXLines.add(grid);
    }

    public void addYGrid(Double value, String label) {
        Grid grid = new Grid(value, label);
        fireCumulatible(EVENT_YGRID_ADDED, grid);
        additionalYLines.add(grid);
    }

    public void removeYGrids() {
        fire(EVENT_YGRID_REMOVED, true);
        additionalYLines.clear();
    }

    public void removeXGrids() {
        fire(EVENT_XGRID_REMOVED, true);
        additionalXLines.clear();
    }
}
