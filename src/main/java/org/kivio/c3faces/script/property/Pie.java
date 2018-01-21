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

import org.kivio.c3faces.script.ObjectBlock;
import org.kivio.c3faces.script.ValueBlock;

/**
 * Through this class is possible to define chart's visual properties, specifically Pie visual properties.
 *
 *
 * @see <a href="http://c3js.org/reference.html">http://c3js.org/reference.html</a> for attrs info
 * @author Martin Linha
 */
public class Pie extends ObjectBlock {

    public static String NAME = "pie";

    private Boolean expand;
    private Boolean showLabels;

    public Pie() {
    }

    public Pie(Boolean expand, Boolean showLabels) {
        this.expand = expand;
        this.showLabels = showLabels;
    }

    @Override
    protected void preScriptBuild() {
        addChild(new ValueBlock("expand", expand));
        addChild(new ObjectBlock("label", new ValueBlock("show", showLabels)));
    }

    @Override
    public String getName() {
        return NAME;
    }

    public Boolean getExpand() {
        return expand;
    }

    public void setExpand(Boolean expand) {
        this.expand = expand;
    }

    public Boolean getShowLabels() {
        return showLabels;
    }

    public void setShowLabel(Boolean showLabels) {
        this.showLabels = showLabels;
    }
}
