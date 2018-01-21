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
 * Through this class is possible to define chart's visual properties, specifically defines attributes of chart's subchart.
 *
 *
 * @see <a href="http://c3js.org/reference.html">http://c3js.org/reference.html</a> for attrs info
 * @author Martin Linha
 */
public class Subchart extends ObjectBlock {

    public static String NAME = "subchart";

    private Boolean show;
    private Integer height;
    private OnbrushMethod onbrushMethodProp;

    public Subchart() {
    }

    public Subchart(Boolean show, Integer height, OnbrushMethod onbrushMethodProp) {
        this.show = show;
        this.height = height;
        this.onbrushMethodProp = onbrushMethodProp;
    }

    @Override
    protected void preScriptBuild() {
        if (show != null) {
            addChild(new ValueBlock("show", show));
        }
        if (height != null) {
            addChild(new ObjectBlock("size", new ValueBlock("height", height)));
        }
        if (onbrushMethodProp != null) {
            addChild(onbrushMethodProp);
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

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public OnbrushMethod getOnbrushMethodProp() {
        return onbrushMethodProp;
    }

    public void setOnbrushMethodProp(OnbrushMethod onbrushMethodProp) {
        this.onbrushMethodProp = onbrushMethodProp;
    }
}
