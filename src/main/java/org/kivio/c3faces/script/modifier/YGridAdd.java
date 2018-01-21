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

import org.kivio.c3faces.script.ArrayBlock;
import org.kivio.c3faces.script.Modifier;
import org.kivio.c3faces.script.ObjectBlock;
import org.kivio.c3faces.script.Property;
import org.kivio.c3faces.script.ValueBlock;
import org.kivio.c3faces.script.property.Grid;
import org.kivio.c3faces.script.property.GridProperties;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Instances of this class can be registered as a listeners to listen changes fired by corresponding objects.
 *
 * The main mission of this class is to provide C3.js scripts for dynamic chart grid changes.
 *
 * @author Martin Linha
 */
public class YGridAdd extends Modifier {

    private static final String ADD = "add";
    private static final String YGRIDS = "ygrids";

    @Override
    protected String getMethodName() {
        return ADD;
    }

    @Override
    public List<String> getFields() {
        return Arrays.asList(YGRIDS);
    }

    @Override
    protected Property getModificationProperty() {
        ArrayBlock ygridArray = new ArrayBlock();

        Set<Grid> grids = (Set<Grid>) getPropertyChangeSet(GridProperties.EVENT_YGRID_ADDED);
        if (grids != null) {

            for (Grid grid : grids) {
                ObjectBlock obj = new ObjectBlock();
                obj.addChild(new ValueBlock("value", grid.getValue()));
                obj.addChild(new ValueBlock("text", grid.getText(), true));
                ygridArray.addChild(obj);
            }
        }
        return ygridArray;
    }
}
