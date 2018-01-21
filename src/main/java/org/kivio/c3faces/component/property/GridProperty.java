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

import javax.faces.component.UIComponentBase;

/**
 * This class allows to declare visual property of type org.kivio.c3faces.script.property.GridProperties in facelet.
 *
 * @author Martin Linha
 */
public class GridProperty extends UIComponentBase {

    public static final String ATTR_VALUE = "value";
    public static final String ATTR_TEXT = "text";

    @Override
    public String getFamily() {
        return "org.kivio.c3faces.component.property";
    }

}
