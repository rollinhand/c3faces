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

import org.kivio.c3faces.listener.change.Change;
import org.kivio.c3faces.model.C3ViewDataSet;
import org.kivio.c3faces.script.Modifier;
import org.kivio.c3faces.script.ObjectBlock;
import org.kivio.c3faces.script.Property;
import org.kivio.c3faces.script.ValueBlock;
import org.kivio.c3faces.script.property.Data;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Instances of this class can be registered as a listeners to listen changes fired by corresponding objects.
 *
 * The main mission of this class is to provide C3.js scripts for dynamic color chart changes.
 *
 * @author Martin Linha
 */
public class Colors extends Modifier {

    private static final String COLORS = "colors";
    private static final String DATA = "data";

    @Override
    protected Property getModificationProperty() {
        ObjectBlock objProp = new ObjectBlock();

        if (getPropertyLastChange(Data.EVENT_VIEW_DATA_SET_ADDED) != null) {
            Set<C3ViewDataSet> load = (Set<C3ViewDataSet>) getPropertyChangeSet(Data.EVENT_VIEW_DATA_SET_ADDED);
            for (C3ViewDataSet dataSet : load) {
                objProp.addChild(new ValueBlock(dataSet.getId(), dataSet.getColor(), true));
            }
        }

        for (Change change : getViewDataSetChanges()) {
            for (Object ch : change.getChangeSet()) {
                Change propertyChange = (Change) ch;
                if (propertyChange.getName().equals(C3ViewDataSet.EVENT_DATA_CHART_COLOR)) {
                    objProp.addChild(new ValueBlock(change.getName(), (String) propertyChange.getLastChange(), true));
                }
            }

        }

        return objProp;
    }

    @Override
    protected String getMethodName() {
        return COLORS;
    }

    @Override
    public List<String> getFields() {
        return Arrays.asList(DATA);
    }

    @Override
    public int getDuration() {
        return 0;
    }

    @Override
    public boolean isTimeoutable() {
        return false;
    }
}
