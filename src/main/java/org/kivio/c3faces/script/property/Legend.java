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
 * Through this class is possible to define chart's visual properties, specifically visual properties of chart's Legend.
 *
 *
 * @see <a href="http://c3js.org/reference.html">http://c3js.org/reference.html</a> for attrs info
 * @author Martin Linha
 */
public class Legend extends ObjectBlock {

    public static final String EVENT_LEGEND_SHOW = "legendShow";
    public static final String EVENT_LEGEND_HIDE = "legendHide";

    public static String NAME = "legend";

    private Legend.Position position;
    private Boolean show;
    private Boolean hide;
    private Legend.InsetAnchor insetAnchor;
    private Integer insetX;
    private Integer insetY;
    private Integer insetStep;
    private OnclickMethod itemOnclick;
    private OnmouseoverMethod itemOnmouseover;
    private OnmouseoutMethod itemOnmouseout;

    public enum Position {

        BOTTOM, RIGHT, INSET
    }

    public enum InsetAnchor {

        TOPLEFT, TOPRIGHT, BOTTOMLEFT, BOTTOMRIGHT
    }

    public Legend() {
    }

    public Legend(Position position, Boolean show, Boolean hide, InsetAnchor insetAnchor, Integer insetX, Integer insetY,
            Integer insetStep, OnclickMethod itemOnclick, OnmouseoverMethod itemOnmouseover,
            OnmouseoutMethod itemOnmouseout) {
        this.position = position;
        this.show = show;
        this.hide = hide;
        this.insetAnchor = insetAnchor;
        this.insetX = insetX;
        this.insetY = insetY;
        this.insetStep = insetStep;
        this.itemOnclick = itemOnclick;
        this.itemOnmouseover = itemOnmouseover;
        this.itemOnmouseout = itemOnmouseout;
    }

    @Override
    protected void preScriptBuild() {
        String positionString = "";
        String anchorString = "";
        if (position != null) {
            positionString = position.name().toLowerCase();
        }
        if (insetAnchor != null) {
            switch (insetAnchor) {
                case BOTTOMLEFT:
                    anchorString = "bottom-left";
                    break;
                case BOTTOMRIGHT:
                    anchorString = "bottom-right";
                    break;
                case TOPLEFT:
                    anchorString = "top-left";
                    break;
                case TOPRIGHT:
                    anchorString = "top-right";
                    break;
            }
        }

        addChild(new ValueBlock("position", positionString, true));
        addChild(new ValueBlock("show", show));
        addChild(new ValueBlock("hide", hide));

        ObjectBlock obj = new ObjectBlock();
        obj.setName("inset");
        obj.addChild(new ValueBlock("anchor", anchorString, true));
        obj.addChild(new ValueBlock("x", insetX));
        obj.addChild(new ValueBlock("y", insetY));
        obj.addChild(new ValueBlock("step", insetStep));
        addChild(obj);

        ObjectBlock item = new ObjectBlock();
        item.setName("item");

        item.addChild(itemOnclick);
        item.addChild(itemOnmouseout);
        item.addChild(itemOnmouseover);
        addChild(item);
    }

    @Override
    public String getName() {
        return NAME;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        fire(EVENT_LEGEND_SHOW, show);
        this.show = show;
    }

    public Boolean getHide() {
        return hide;
    }

    public void setHide(Boolean hide) {
        fire(EVENT_LEGEND_HIDE, hide);
        this.hide = hide;
    }

    public InsetAnchor getInsetAnchor() {
        return insetAnchor;
    }

    public void setInsetAnchor(InsetAnchor insetAnchor) {
        this.insetAnchor = insetAnchor;
    }

    public Integer getInsetX() {
        return insetX;
    }

    public void setInsetX(Integer insetX) {
        this.insetX = insetX;
    }

    public Integer getInsetY() {
        return insetY;
    }

    public void setInsetY(Integer insetY) {
        this.insetY = insetY;
    }

    public Integer getInsetStep() {
        return insetStep;
    }

    public void setInsetStep(Integer insetStep) {
        this.insetStep = insetStep;
    }

    public OnclickMethod getItemOnclick() {
        return itemOnclick;
    }

    public void setItemOnclick(OnclickMethod itemOnclick) {
        this.itemOnclick = itemOnclick;
    }

    public OnmouseoverMethod getItemOnmouseover() {
        return itemOnmouseover;
    }

    public void setItemOnmouseover(OnmouseoverMethod itemOnmouseover) {
        this.itemOnmouseover = itemOnmouseover;
    }

    public OnmouseoutMethod getItemOnmouseout() {
        return itemOnmouseout;
    }

    public void setItemOnmouseout(OnmouseoutMethod itemOnmouseout) {
        this.itemOnmouseout = itemOnmouseout;
    }
}
