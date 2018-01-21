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
 * Through this class is possible to define chart's visual properties, specifically adds Regions to chart.
 *
 *
 * @see <a href="http://c3js.org/reference.html">http://c3js.org/reference.html</a> for attrs info
 * @author Martin Linha
 */
public class Regions extends ValueBlock {

    public static String NAME = "regions";

    private List<Region> regions = new ArrayList<>();

    public Regions() {
    }

    public Regions(List<Region> regions) {
        this.regions = regions;
    }

    @Override
    protected void preScriptBuild() {
        if (regions != null && !regions.isEmpty()) {
            ArrayBlock regionsArray = new ArrayBlock();
            for (Region region : regions) {
                ObjectBlock regionObj = new ObjectBlock();
                regionObj.addChild(new ValueBlock("axis", region.getAxis(), true));
                regionObj.addChild(new ValueBlock("start", region.getStart()));
                regionObj.addChild(new ValueBlock("end", region.getEnd()));
                regionObj.addChild(new ValueBlock("class", region.getCssClass(), true));
                regionsArray.addChild(regionObj);
            }
            addChild(regionsArray, true);
        }
    }

    public List<Region> getRegions() {
        return regions;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
