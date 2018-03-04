/**
 Copyright 2018 Björn Berg

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
package org.kivio.c3faces.component.property;

import org.kivio.c3faces.constants.Family;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;

/**
 * This class allows to declare if axis should be rotated or not. It is also
 * the top class for {@link AxisXProperty} and {@link AxisYProperty}.
 *
 * It is an outer class around.
 *
 * @author Björn Berg, rollin.hand@gmx.de
 * @since 2018-01-21
 */
public class AxisProperty extends UIComponentBase {
    public static final String ATTR_SHOW = "show";
    public static final String ATTR_TYPE = "type";
    public static final String ATTR_CATEGORIES = "categories";
    public static final String ATTR_LOCALTIME = "localtime";
    public static final String ATTR_HEIGHT = "height";

    @Override
    public String getFamily() {
        return Family.PROPERTY.toString();
    }
}
