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
import org.kivio.c3faces.script.ArrayBlock;
import org.kivio.c3faces.script.Modifier;
import org.kivio.c3faces.script.ObjectBlock;
import org.kivio.c3faces.script.Property;
import org.kivio.c3faces.script.ValueBlock;
import org.kivio.c3faces.script.property.Data;
import org.kivio.c3faces.util.JSTools;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Instances of this class can be registered as a listeners to listen changes fired by corresponding objects.
 *
 * The main mission of this class is to provide C3.js scripts for dynamic data chart changes.
 *
 * @author Martin Linha
 */
public class Load extends Modifier {

    private static final String LOAD = "load";
    private static final String UNLOAD = "unload";
    private static final String COLUMNS = "columns";
    private static final String TYPES = "types";

    @Override
    protected String getMethodName() {
        return LOAD;
    }

    @Override
    protected Property getModificationProperty() {
        ObjectBlock data = new ObjectBlock();
        Set<C3ViewDataSet> load = new LinkedHashSet<>();
        Set<C3ViewDataSet> unload = new LinkedHashSet<>();
        Set<String> keyToUnload = new HashSet<>();

        if (getPropertyLastChange(Data.EVENT_VIEW_DATA_SET_ADDED) != null) {
            load.addAll((LinkedHashSet<C3ViewDataSet>) getPropertyChangeSet(Data.EVENT_VIEW_DATA_SET_ADDED));

            // generate also chart types
            ObjectBlock types = new ObjectBlock();
            types.setName(TYPES);
            for (C3ViewDataSet dataSet : load) {
                if (dataSet.getType() != null) {
                    types.addChild(new ValueBlock(dataSet.getId(), dataSet.getType(), true));
                }
            }
            data.addChild(types);
        }

        // if new C3DataSet object changes, add to load list
        for (Change change : getViewDataSetChanges()) {
            for (Object ch : change.getChangeSet()) {
                Change propertyChange = (Change) ch;
                if (propertyChange.getName().equals(C3ViewDataSet.EVENT_DATA_SET_CHANGE)) {
                    C3ViewDataSet set = (C3ViewDataSet) propertyChange.getLastChange();
                    if (set.getDataSet() != null) {
                        load.add(set);
                    } else {
                        keyToUnload.add(set.getId());
                    }
                }
            }
        }

        data.addChild(new ValueBlock(COLUMNS, new ArrayBlock(JSTools.columns(load))));

        if (getPropertyLastChange(Data.EVENT_VIEW_DATA_SET_REMOVED) != null) {
            unload.addAll((Set<C3ViewDataSet>) getPropertyChangeSet(Data.EVENT_VIEW_DATA_SET_REMOVED));

            for (C3ViewDataSet dataSet : unload) {
                keyToUnload.add(dataSet.getId());
            }
        }
        data.addChild(new ValueBlock(UNLOAD, new ArrayBlock(JSTools.commaSeparatedStringsQuoted(keyToUnload))));

        return data;
    }
}
