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
import org.kivio.c3faces.script.property.OnzoomMethod;
import org.kivio.c3faces.script.property.Zoom;
import org.kivio.c3faces.util.ComponentUtil;
import javax.faces.component.FacesComponent;

/**
 * This class allows to declare visual property of type org.kivio.c3faces.script.property.Zoom in facelet.
 *
 * @author Martin Linha
 */
@FacesComponent("org.kivio.c3faces.component.property.ZoomProperty")
public class ZoomProperty extends C3Property {

    private enum PropertyKeys {

        enabled, rescale, extentFrom, extentTo, onzoom
    }
    private static final String ATTR_ENABLED = "enabled";
    private static final String ATTR_RESCALE = "rescale";
    private static final String ATTR_EXTENT_FROM = "extentFrom";
    private static final String ATTR_EXTENT_TO = "extentTo";
    private static final String ATTR_ONZOOM = "onzoom";

    @Override
    public Property getAssociatedProperty() {
        String onzoomAttr = (String) getAttributes().get(ATTR_ONZOOM);
        OnzoomMethod onzoom = null;
        if (onzoomAttr != null) {
            onzoom = new OnzoomMethod(onzoomAttr);
        }

        return new Zoom(ComponentUtil.parseBoolean(ATTR_ENABLED),
                ComponentUtil.parseBoolean(ATTR_RESCALE),
                ComponentUtil.parseInteger(ATTR_EXTENT_FROM),
                ComponentUtil.parseInteger(ATTR_EXTENT_TO), onzoom);
    }
}
