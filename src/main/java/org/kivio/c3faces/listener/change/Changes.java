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
package org.kivio.c3faces.listener.change;

import org.kivio.c3faces.listener.ChangeListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Class which implements ChangeListener and provides base implemention for collecting changes of listener.
 *
 * @author Martin Linha
 */
public abstract class Changes implements ChangeListener {

    private final Map<String, Change> changedProps = new HashMap<>();

    /**
     * Returns last change of property with specified name. If no change found with specified name, returns null.
     *
     * @param changeName Name of change
     * @return Last added object to change instance if is found
     */
    public Object getPropertyLastChange(String changeName) {
        if (changedProps.get(changeName) == null) {
            return null;
        }
        return changedProps.get(changeName).getLastChange();
    }

    /**
     * Returns all ViewDataSetChange and ViewDataSetCumulatibleChange contained in collection of Changes.
     *
     * @return All ViewDataSetChange and ViewDataSetCumulatibleChange instances
     */
    public Set<Change> getViewDataSetChanges() {
        Set<Change> set = new HashSet<>();
        for (Entry entry : changedProps.entrySet()) {
            if (entry.getValue() instanceof ViewDataSetChange) {
                set.add((ViewDataSetChange) entry.getValue());
            }
            if (entry.getValue() instanceof ViewDataSetCumulatibleChange) {
                set.add((ViewDataSetCumulatibleChange) entry.getValue());
            }
        }
        return set;
    }

    /**
     * Returns set of all objects added to change instance. If no change is found, returns null.
     *
     * @param changeName
     * @return Set of all objects added to change instance
     */
    public Set<?> getPropertyChangeSet(String changeName) {
        if (changedProps.get(changeName) == null) {
            return null;
        }
        return changedProps.get(changeName).getChangeSet();
    }

    /**
     * Implements onChange method. If change is already contained in map of changes and is cumulatible, adds change to change instance. Else adds to
     * map of changes.
     *
     * @param change Change to be added
     */
    @Override
    public void onChange(Change<?> change) {
        Change changedProp = changedProps.get((String) change.getName());
        if (changedProp != null && changedProp.isCumulatible()) {
            changedProp.addValue(change.getLastChange());
        } else {
            changedProps.put(change.getName(), change);
        }
    }

    /**
     * Returns map of all changes
     *
     * @return Map of all changes
     */
    public Map<String, Change> getChangedProps() {
        return changedProps;
    }
}
