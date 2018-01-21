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
package org.kivio.c3faces.component;

import org.kivio.c3faces.constants.ChartType;
import org.kivio.c3faces.script.Property;
import java.util.List;
import javax.faces.component.FacesComponent;

/**
 * Class for component which allows to declare C3.js chart of type Line in facelet.
 *
 * It does not return any default properties to component.
 *
 * @author Martin Linha
 */
@FacesComponent("org.kivio.c3faces.component.Line")
public class Line extends C3Chart {

    @Override
    public List<Property> getDefaultProperties() {
        return null;
    }

    @Override
    public String getChartType() {
        return ChartType.LINE.getName();
    }

}
