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
package org.kivio.c3faces.component.property;

import org.kivio.c3faces.script.Property;
import org.kivio.c3faces.script.property.Tooltip;
import org.kivio.c3faces.util.ComponentUtil;
import javax.faces.component.FacesComponent;

/**
 * This class allows to declare visual property of type org.kivio.c3faces.script.property.Tooltip in facelet.
 *
 * @author Martin Linha
 */
@FacesComponent("org.kivio.c3faces.component.property.TooltipProperty")
public class TooltipProperty extends C3Property {

    private static final String ATTR_SHOW = "show";
    private static final String ATTR_GROUPED = "grouped";

    @Override
    public Property getAssociatedProperty() {
        return new Tooltip(ComponentUtil.parseBoolean(getAttributes().get(ATTR_SHOW)), ComponentUtil.parseBoolean(getAttributes().get(ATTR_GROUPED)));
    }
}
