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

import org.kivio.c3faces.model.C3Category;
import org.kivio.c3faces.script.Property;
import org.kivio.c3faces.script.property.Axis;
import org.kivio.c3faces.util.ComponentUtil;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponent;
import java.util.Collections;
import java.util.Set;

/**
 * AxesProperty configures the X-axis and Y-axis as suggested by C3.js.
 *
 * @author Björn Berg, rollin.hand@gmx.de
 * @since 2018-01-21
 */
@FacesComponent("org.kivio.c3faces.component.property.AxesProperty")
public class AxesProperty extends C3Property {
    private static final String ATTR_ROTATED = "rotated";

    @Override
    public Property getAssociatedProperty() {
        Axis axis = new Axis();
        axis.setRotated(ComponentUtil.parseBoolean(getAttributes().get(ATTR_ROTATED)));

        for (UIComponent component : getChildren()) {
            if (component instanceof AxisXProperty) {
                axis.setShowX(ComponentUtil.parseBoolean(component.getAttributes().get(AxisProperty.ATTR_SHOW)));
                axis.setHeightX(ComponentUtil.parseInteger(component.getAttributes().get(AxisProperty.ATTR_HEIGHT)));
                // TODO: we will support localtime later
                //axis.setLocaltimeX(ComponentUtil.parseBoolean(component.getAttributes().get(AxisProperty.ATTR_LOCALTIME)));
                axis.setTypeX(ComponentUtil.findEnum(Axis.Type.class, (String) component.getAttributes().get(AxisProperty.ATTR_TYPE)));
                axis.setCategoriesX(parseCategory(component.getAttributes().get(AxisProperty.ATTR_CATEGORIES)));
            } else if (component instanceof AxisYProperty) {
                axis.setShowY(ComponentUtil.parseBoolean(component.getAttributes().get(AxisProperty.ATTR_SHOW)));
                axis.setHeightY(ComponentUtil.parseInteger(component.getAttributes().get(AxisProperty.ATTR_HEIGHT)));
                // TODO: we will support localtime later
                //axis.setLocaltimeY(ComponentUtil.parseBoolean(component.getAttributes().get(AxisProperty.ATTR_LOCALTIME)));
                axis.setTypeY(ComponentUtil.findEnum(Axis.Type.class, (String) component.getAttributes().get(AxisProperty.ATTR_TYPE)));
                axis.setCategoriesY(parseCategory(component.getAttributes().get(AxisProperty.ATTR_CATEGORIES)));
            }
        }

        return axis;
    }

    /**
     * Get Set of categories from {@link C3Category}.
     * @param o attributes input.
     * @return Set or null.
     */
    private Set<String> parseCategory(Object o) {
        if (o == null) {
            return Collections.emptySet();
        }

        return (o instanceof C3Category) ? ((C3Category)o).getValues() : null;
    }
}
