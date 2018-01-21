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
 * Through this class is possible to define chart's visual properties, specifically visual properties of each chart's point.
 *
 *
 * @see <a href="http://c3js.org/reference.html">http://c3js.org/reference.html</a> for attrs info
 * @author Martin Linha
 */
public class Point extends ObjectBlock {
    
    public static String NAME = "point";

    private Boolean show;
    private Double r;
    private Boolean expand;
    private Double expandR;
    private Double selectR;

    public Point() {
    }

    public Point(Boolean show, Double r, Boolean expand, Double expandR, Double selectR) {
        this.show = show;
        this.r = r;
        this.expand = expand;
        this.expandR = expandR;
        this.selectR = selectR;
    }

    @Override
    public void preScriptBuild() {
        if (show != null) {
            addChild(new ValueBlock("show", show));
        }
        if (r != null) {
            addChild(new ValueBlock("r", r));
        }
        if (expand != null) {
            addChild(new ObjectBlock("focus", new ObjectBlock("expand", new ValueBlock("enabled", expand))));
        }
        if (expandR != null) {
            addChild(new ObjectBlock("focus", new ObjectBlock("expand", new ValueBlock("r", expandR))));
        }
        if (selectR != null) {
            addChild(new ObjectBlock("select", new ValueBlock("r", selectR)));
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

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public Boolean getExpand() {
        return expand;
    }

    public void setExpand(Boolean expand) {
        this.expand = expand;
    }

    public Double getExpandR() {
        return expandR;
    }

    public void setExpandR(Double expandR) {
        this.expandR = expandR;
    }

    public Double getSelectR() {
        return selectR;
    }

    public void setSelectR(Double selectR) {
        this.selectR = selectR;
    }
}
