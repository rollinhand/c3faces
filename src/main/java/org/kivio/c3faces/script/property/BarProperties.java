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
 * Through this class is possible to define chart's visual properties, specifically Bar visual properties.
 *
 *
 * @see <a href="http://c3js.org/reference.html">http://c3js.org/reference.html</a> for attrs info
 * @author Martin Linha
 */
public class BarProperties extends ObjectBlock {

    public static String NAME = "bar";

    private Integer width;
    private Boolean zerobased;

    public BarProperties() {
    }

    public BarProperties(Integer width, Boolean zerobased) {
        this.width = width;
        this.zerobased = zerobased;
    }

    @Override
    protected void preScriptBuild() {
        if (width != null) {
            addChild(new ValueBlock("width", width));
        }

        if (zerobased != null) {
            addChild(new ValueBlock("zerobased", zerobased));
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
        this.width = width;
    }

    public Boolean getZerobased() {
        return zerobased;
    }

    public void setZerobased(Boolean zerobased) {
        this.zerobased = zerobased;
    }
}
