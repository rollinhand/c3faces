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
package org.kivio.c3faces.constants;

/**
 * Contains enumeration of actual chart types provided by C3.js.
 *
 * @author Martin Linha
 */
public enum ChartType {

    LINE("line"), SPLINE("spline"), STEP("step"), AREA("area"), AREASPLINE("area-spline"),
    AREASTEP("area-step"), BAR("bar"), SCATTER("scatter"), PIE("pie"), DONUT("donut"), GAUGE("gauge");

    private String name;

    private ChartType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
