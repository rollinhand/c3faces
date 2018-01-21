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
 * Through this class is possible to define chart's visual properties, specifically visual properties of chart's tooltip.
 *
 *
 * @see <a href="http://c3js.org/reference.html">http://c3js.org/reference.html</a> for attrs info
 * @author Martin Linha
 */
public class Tooltip extends ObjectBlock {

    public static String NAME = "tooltip";

    private Boolean show;
    private Boolean grouped;

    public Tooltip() {
    }

    public Tooltip(Boolean show, Boolean grouped) {
        this.show = show;
        this.grouped = grouped;
    }

    @Override
    protected void preScriptBuild() {
        if (show != null) {
            addChild(new ValueBlock("show", show));
        }
        if (grouped != null) {
            addChild(new ValueBlock("grouped", grouped));
        }
    }

    @Override
    public String getName() {
        return NAME;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public Boolean getGrouped() {
        return grouped;
    }

    public void setGrouped(Boolean grouped) {
        this.grouped = grouped;
    }
}
