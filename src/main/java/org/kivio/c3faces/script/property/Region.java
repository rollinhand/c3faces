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

/**
 * Through this class is possible to define chart's visual properties, specifically adds Region to chart.
 *
 *
 * @see <a href="http://c3js.org/reference.html">http://c3js.org/reference.html</a> for attrs info
 * @author Martin Linha
 */
public class Region {

    private String axis;
    private Double start;
    private Double end;
    private String cssClass;

    public Region(String axis, Double start, Double end, String cssClass) {
        this.axis = axis;
        this.start = start;
        this.end = end;
        this.cssClass = cssClass;
    }

    public String getAxis() {
        return axis;
    }

    public void setAxis(String axis) {
        this.axis = axis;
    }

    public Double getStart() {
        return start;
    }

    public void setStart(Double start) {
        this.start = start;
    }

    public Double getEnd() {
        return end;
    }

    public void setEnd(Double end) {
        this.end = end;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

}
