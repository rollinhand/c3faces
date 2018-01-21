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

/**
 * Through this class is possible to define chart's visual properties, specifically defines the behavior of chart's zoom capabilities.
 *
 * @author Martin Linha
 */
public class Zoom extends ObjectBlock {

    public static String NAME = "zoom";

    private Boolean enabled;
    private Boolean rescale;
    private Integer extentFrom;
    private Integer extentTo;
    private OnzoomMethod onzoomMethodProp;

    public Zoom() {
    }

    public Zoom(Boolean enabled, Boolean rescale, Integer extentFrom, Integer extentTo, OnzoomMethod onzoomMethodProp) {
        this.enabled = enabled;
        this.rescale = rescale;
        this.extentFrom = extentFrom;
        this.extentTo = extentTo;
        this.onzoomMethodProp = onzoomMethodProp;
    }

    @Override
    protected void preScriptBuild() {
        if (enabled != null) {
            addChild(new ValueBlock("enabled", enabled));
        }
        if (rescale != null) {
            addChild(new ValueBlock("rescale", rescale));
        }

        if (extentFrom != null && extentTo != null) {
            addChild(new ValueBlock("extent", new ArrayBlock(extentFrom + ", " + extentTo)));
        }

        if (onzoomMethodProp != null) {
            addChild(onzoomMethodProp);
        }
    }

    @Override
    public String getName() {
        return NAME;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getRescale() {
        return rescale;
    }

    public void setRescale(Boolean rescale) {
        this.rescale = rescale;
    }

    public Integer getExtentFrom() {
        return extentFrom;
    }

    public void setExtentFrom(Integer extentFrom) {
        this.extentFrom = extentFrom;
    }

    public Integer getExtentTo() {
        return extentTo;
    }

    public void setExtentTo(Integer extentTo) {
        this.extentTo = extentTo;
    }

    public OnzoomMethod getOnzoomMethodProp() {
        return onzoomMethodProp;
    }

    public void setOnzoomMethodProp(OnzoomMethod onzoomMethodProp) {
        this.onzoomMethodProp = onzoomMethodProp;
    }
}
