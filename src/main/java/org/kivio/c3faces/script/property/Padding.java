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
 * Through this class is possible to define chart's visual properties, specifically padding of chart.
 *
 *
 * @see <a href="http://c3js.org/reference.html">http://c3js.org/reference.html</a> for attrs info
 * @author Martin Linha
 */
public class Padding extends ObjectBlock {

    public static String NAME = "padding";

    private Integer top;
    private Integer right;
    private Integer left;
    private Integer bottom;

    public Padding() {
    }

    public Padding(Integer top, Integer right, Integer left, Integer bottom) {
        this.top = top;
        this.right = right;
        this.left = left;
        this.bottom = bottom;
    }

    @Override
    protected void preScriptBuild() {
        if (top != null) {
            addChild(new ValueBlock("top", top));
        }
        if (right != null) {
            addChild(new ValueBlock("right", right));
        }
        if (left != null) {
            addChild(new ValueBlock("left", left));
        }
        if (bottom != null) {
            addChild(new ValueBlock("bottom", bottom));
        }
    }

    @Override
    public String getName() {
        return NAME;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getRight() {
        return right;
    }

    public void setRight(Integer right) {
        this.right = right;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Integer getBottom() {
        return bottom;
    }

    public void setBottom(Integer bottom) {
        this.bottom = bottom;
    }
}
