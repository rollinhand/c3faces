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

import org.kivio.c3faces.script.Modifier;
import org.kivio.c3faces.script.Property;
import org.kivio.c3faces.script.modifier.XGridAdd;
import org.kivio.c3faces.script.modifier.XGridRemove;
import org.kivio.c3faces.script.modifier.YGridAdd;
import org.kivio.c3faces.script.modifier.YGridRemove;
import org.kivio.c3faces.script.property.GridProperties;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponent;

/**
 * This class allows to declare visual property of type org.kivio.c3faces.script.property.GridProperties in facelet.
 *
 * @author Martin Linha
 */
@FacesComponent("org.kivio.c3faces.component.property.GridsProperty")
public class GridsProperty extends C3Property {
    
    private static final String ATTR_SHOW_X = "showX";
    private static final String ATTR_SHOW_Y = "showY";
    
    @Override
    public Property getAssociatedProperty() {
        GridProperties grid = new GridProperties();
        Map<Double, String> additionalXLines = null;
        Map<Double, String> additionalYLines = null;
        Modifier mod = new XGridAdd()
                .addModifier(new XGridRemove())
                .addModifier(new YGridAdd())
                .addModifier(new YGridRemove());
        
        for (UIComponent component : getChildren()) {
            if (component instanceof GridXProperty) {
                if (additionalXLines == null) {
                    additionalXLines = new HashMap<>();
                }
                additionalXLines.put(Double.parseDouble((String) component.getAttributes().get(GridProperty.ATTR_VALUE)),
                        (String) component.getAttributes().get(GridProperty.ATTR_TEXT));
                
            }
            if (component instanceof GridYProperty) {
                if (additionalYLines == null) {
                    additionalYLines = new HashMap<>();
                }
                additionalYLines.put(Double.parseDouble((String) component.getAttributes().get(GridProperty.ATTR_VALUE)),
                        (String) component.getAttributes().get(GridProperty.ATTR_TEXT));
            }
        }
        if (additionalXLines != null) {
            for (Entry<Double, String> entry : additionalXLines.entrySet()) {
                grid.addXGrid(entry.getKey(), entry.getValue());
            }
        }
        if (additionalYLines != null) {
            for (Entry<Double, String> entry : additionalYLines.entrySet()) {
                grid.addYGrid(entry.getKey(), entry.getValue());
            }
        }
        grid.addListener(mod);
        return grid;
    }
}
