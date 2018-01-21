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

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Objects of this class containes changes made on chart's visual properties.
 *
 * @author Martin Linha
 * @param <T>
 */
public class Change<T> {

    private final String name;
    private T lastChangeValue;
    private final Set<T> changeSet = new LinkedHashSet<>();
    private final boolean cumulatible = false;

    public Change(String name, T value) {
        this.name = name;
        lastChangeValue = value;
        addValue(value);
    }

    /**
     * Add new change value. Sets last change and adds new change to change set.
     *
     * @param value Value of change
     */
    protected final void addValue(T value) {
        lastChangeValue = value;
        changeSet.add(value);
    }

    /**
     * If change is cumulatible, then saves all historical changes.
     *
     * @return True if is cumulatible
     */
    public boolean isCumulatible() {
        return cumulatible;
    }

    /**
     * Returns set of changes.
     *
     * @return All change objects.
     */
    public Set<T> getChangeSet() {
        return changeSet;
    }

    /**
     * Return last change added to instance of this class.
     *
     * @return Last change object
     */
    public T getLastChange() {
        return lastChangeValue;
    }

    /**
     * Returns name of change
     *
     * @return Name of change
     */
    public String getName() {
        return name;
    }
}
