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
 * Through this class is possible to define chart's visual properties, specifically size of chart.
 *
 *
 * @see <a href="http://c3js.org/reference.html">http://c3js.org/reference.html</a> for attrs info
 * @author Martin Linha
 */
public class Size extends ObjectBlock {

    public static final String EVENT_WIDTH_CHANGED = "sizeWidthChanged";
    public static final String EVENT_HEIGHT_CHANGED = "sizeHeightChanged";

    public static String NAME = "size";

    private Integer width;
    private Integer height;

    public Size() {
    }

    public Size(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    @Override
    protected void preScriptBuild() {
        if (width != null) {
            addChild(new ValueBlock("width", width));
        }
        if (height != null) {
            addChild(new ValueBlock("height", height));
        }
    }

    @Override
    public String getName() {
        return NAME;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        fire(EVENT_WIDTH_CHANGED, width);
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        fire(EVENT_HEIGHT_CHANGED, height);
        this.height = height;
    }
}
