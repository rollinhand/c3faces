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
package org.kivio.c3faces.script.modifier;

import org.kivio.c3faces.script.Modifier;
import org.kivio.c3faces.script.Property;
import org.kivio.c3faces.script.ValueBlock;
import org.kivio.c3faces.script.property.Data;

/**
 * Instances of this class can be registered as a listeners to listen changes fired by corresponding objects.
 *
 * The main mission of this class is to provide C3.js scripts for dynamic chart type changes.
 *
 * @author Martin Linha
 */
public class Transform extends Modifier {

    private static final String TRANSFORM = "transform";

    @Override
    protected Property getModificationProperty() {
        return new ValueBlock(null, (String) getPropertyLastChange(Data.EVENT_CHART_TYPE_CHANGED), true);
    }

    @Override
    protected String getMethodName() {
        return TRANSFORM;
    }

    @Override
    public boolean includePropName() {
        return true;
    }
}
