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
package org.kivio.c3faces.component;

import org.kivio.c3faces.listener.ChangeListener;
import org.kivio.c3faces.listener.PropertyModifier;
import org.kivio.c3faces.script.Modifier;
import org.kivio.c3faces.script.Property;
import org.kivio.c3faces.script.modifier.Colors;
import org.kivio.c3faces.script.modifier.Load;
import org.kivio.c3faces.script.modifier.Names;
import org.kivio.c3faces.script.modifier.Transform;
import org.kivio.c3faces.script.modifier.TransformTypes;
import org.kivio.c3faces.script.property.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class which encapsulates chart's visual properties of type org.kivio.c3faces.script.Property. C3Chart objects keeps instances of this class
 * in StateHelper to keep properties for enough time.
 *
 * @author Martin Linha
 */
public class ComponentProperties implements Serializable {

    private final Map<String, Property> properties = new HashMap<>();

    /**
     * Returns chart's org.kivio.c3faces.script.property.Data object.
     *
     * @return Chart's Data object.
     */
    public Data getComponentData() {
        Data data = (Data) getProperty(Data.NAME);
        return data;
    }

    /**
     * Method used to add new property.
     *
     * WARNING! Will not be added if property of same name (property.getName()) is already contained in collection.
     *
     * @param property Object to be added
     * @return True if property is added.
     */
    public boolean addProperty(Property property) {
        boolean added = false;
        if (!properties.containsKey(property.getName())) {
            properties.put(property.getName(), property);
            added = true;
        }
        return added;
    }

    /**
     * Adds new Data to properties collection. New Data instance also injects with basic listeners.
     *
     * @param data Data to be added
     * @return Returns true, if Data instance is new or changed from last addition
     */
    boolean addProperty(Data data) {
        Data oldData = (Data) properties.get(Data.NAME);
        properties.put(Data.NAME, data);

        boolean addedNew = oldData == null ? true : data != oldData;

        if (addedNew) {
            Modifier dataModifier = new Load();
            dataModifier.addModifier(new Names());
            dataModifier.addModifier(new Colors());
            dataModifier.addModifier(new Transform());
            dataModifier.addModifier(new TransformTypes());
            data.addListener(dataModifier);
        }
        return addedNew;
    }

    /**
     * Adds all properties from collection.
     *
     * WARNING! Properties with name (property#getName()) of another property already contained in collection of this class will not be added.
     *
     * @param props Collection of properties to be added
     */
    public void addProperties(Collection<Property> props) {
        if (props == null) {
            return;
        }
        for (Property prop : props) {
            addProperty(prop);
        }
    }

    /**
     * Returns property from map by property name.
     *
     * @param key Property name to be returned
     * @return Property of specified name
     */
    public Property getProperty(String key) {
        return properties.get(key);
    }

    /**
     * Returns read-only properties collection. To add new property, use ComponentProperties#addProperty().
     *
     * WARNING! Changes to this list won't affect chart's properties.
     *
     * @return Read-only list of all properties
     */
    public List<Property> getProperties() {
        return new ArrayList<>(properties.values());
    }

    /**
     * Returns list of all objects org.kivio.c3faces.listener.PropertyModifier associated to all of the properties.
     *
     * @return List of all registered PropertyModifiers to all properties
     */
    public List<PropertyModifier> getPropertyModifiers() {
        List<PropertyModifier> modifiers = new ArrayList<>();
        for (Property prop : getProperties()) {

            for (ChangeListener listener : prop.getListeners()) {
                if (listener instanceof PropertyModifier) {
                    if (!modifiers.contains((PropertyModifier) listener)) {
                        modifiers.add((PropertyModifier) listener);
                    }
                }
            }
        }
        return modifiers;
    }

    /**
     * Will call PropertyModifier#reset() on all registered objects of type org.kivio.c3faces.listener.PropertyModifier.
     *
     */
    public void resetListeners() {

        for (Property prop : getProperties()) {
            for (ChangeListener listener : prop.getListeners()) {
                if (listener instanceof PropertyModifier) {
                    PropertyModifier mod = (PropertyModifier) listener;
                    mod.reset();
                }
            }
        }
    }

    /**
     * Method with only friendly access used to clear map of properties.
     *
     */
    void clearProperties() {
        properties.clear();
    }
}
