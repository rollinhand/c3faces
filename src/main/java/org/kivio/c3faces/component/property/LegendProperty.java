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
import org.kivio.c3faces.script.modifier.LegendHide;
import org.kivio.c3faces.script.modifier.LegendShow;
import org.kivio.c3faces.script.property.Legend;
import org.kivio.c3faces.script.property.OnclickMethod;
import org.kivio.c3faces.util.ComponentUtil;
import javax.faces.component.FacesComponent;

/**
 * This class allows to declare visual property of type org.kivio.c3faces.script.property.Legend in facelet.
 *
 * @author Martin Linha
 */
@FacesComponent("org.kivio.c3faces.component.property.LegendProperty")
public class LegendProperty extends C3Property {

    private static final String ATTR_POSITION = "position";
    private static final String ATTR_SHOW = "show";
    private static final String ATTR_HIDE = "hide";
    private static final String ATTR_INSET_ANCHOR = "insertAnchor";
    private static final String ATTR_INSET_X = "insetX";
    private static final String ATTR_INSET_Y = "insetY";
    private static final String ATTR_INSET_STEP = "insetStep";
    private static final String ATTR_ITEM_ONCLICK = "onclick";
    private static final String ATTR_ITEM_ONMOUSEOVER = "onmouseover";
    private static final String ATTR_ITEM_ONMOUSEOUT = "onmouseout";

    @Override
    public Property getAssociatedProperty() {

        Modifier mod = new LegendHide().addModifier(new LegendShow());

        Legend legend = new Legend(ComponentUtil.findEnum(Legend.Position.class, (String) getAttributes().get(ATTR_POSITION)),
                ComponentUtil.parseBoolean((String) getAttributes().get(ATTR_SHOW)), ComponentUtil.parseBoolean((String) getAttributes().get(ATTR_HIDE)),
                ComponentUtil.findEnum(Legend.InsetAnchor.class, (String) getAttributes().get(ATTR_INSET_ANCHOR)),
                ComponentUtil.parseInteger(getAttributes().get(ATTR_INSET_X)), ComponentUtil.parseInteger(getAttributes().get(ATTR_INSET_Y)),
                ComponentUtil.parseInteger(getAttributes().get(ATTR_INSET_STEP)), null, null, null);
        legend.addListener(mod);

        String onclick = (String) getAttributes().get(ATTR_ITEM_ONCLICK);
        if (onclick != null) {
            legend.setItemOnclick(new OnclickMethod(onclick));
        }
        String onmouseover = (String) getAttributes().get(ATTR_ITEM_ONMOUSEOVER);
        if (onmouseover != null) {
            legend.setItemOnclick(new OnclickMethod(onmouseover));
        }
        String onmouseout = (String) getAttributes().get(ATTR_ITEM_ONMOUSEOUT);
        if (onmouseout != null) {
            legend.setItemOnclick(new OnclickMethod(onmouseout));
        }

        return legend;
    }
}
