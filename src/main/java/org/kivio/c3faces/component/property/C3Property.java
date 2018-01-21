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
import javax.faces.component.UIComponentBase;

/**
 * Class for transforming objects of type org.kivio.c3faces.component.property.Property to UIComponents. After this is made, component can be
 * declared in facelet in body of chart's tag. Chart will then easy looks for objects of this type, takes the associated
 * org.kivio.c3faces.component.property.Property object and add it to its property collection.
 *
 * @author Martin Linha
 */
public abstract class C3Property extends UIComponentBase {

    /**
     * Component won't even render, so renderer is unnecessary. Return null.
     *
     * @return null
     */
    @Override
    public String getRendererType() {
        return null;
    }

    @Override
    public String getFamily() {
        return "org.kivio.c3faces.component.property";
    }

    /**
     * Through this method is possible to supply the visual property of type org.kivio.c3faces.component.property.Property. After this
     * UIComponent is declared in body of facelet, chart will takes the returned object and adds it to chart's properties.
     *
     * @return Property which should be added to chart's properties
     */
    public abstract Property getAssociatedProperty();
}
