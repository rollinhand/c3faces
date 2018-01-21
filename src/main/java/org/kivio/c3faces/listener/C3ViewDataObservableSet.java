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
package org.kivio.c3faces.listener;

import org.kivio.c3faces.model.C3ViewDataSet;
import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * Concrete implementation of ObservableSet to observe changes made on set of objects of type C3ViewDataSet.
 *
 * It also populates listeners for C3ViewDataSet.
 *
 * @author Martin Linha
 */
public class C3ViewDataObservableSet extends ObservableSet<C3ViewDataSet> {

    public C3ViewDataObservableSet(LinkedHashSet<C3ViewDataSet> wrappedSet, String eventAddedName, String eventRemovedName) {
        super(wrappedSet, eventAddedName, eventRemovedName);
    }

    /**
     * Set new wrapped set and populate listeners to all of its elements.
     *
     * @param wrappedSet To be set and populated
     */
    @Override
    public void setWrappedSet(LinkedHashSet<C3ViewDataSet> wrappedSet) {
        for (C3ViewDataSet c : wrappedSet) {
            c.setListeners(getListeners());
        }
        super.setWrappedSet(wrappedSet);
    }

    /**
     * Add new C3ViewDataSet and populate its listeners.
     *
     * @param e C3ViewDataSet to be added and populated
     * @return True if addition was successful
     */
    @Override
    public boolean add(C3ViewDataSet e) {
        e.setListeners(getListeners());
        return super.add(e);
    }

    /**
     * Add multiple new C3ViewDataSet and populate their listeners.
     *
     * @param c C3ViewDataSets to be added and populated
     * @return True if addition was successful
     */
    @Override
    public boolean addAll(Collection<? extends C3ViewDataSet> c) {
        for (C3ViewDataSet data : c) {
            data.setListeners(getListeners());
        }
        return super.addAll(c);
    }
}
