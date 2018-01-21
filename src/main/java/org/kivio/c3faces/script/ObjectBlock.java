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
package org.kivio.c3faces.script;

import org.kivio.c3faces.listener.ChangeListener;
import java.util.Arrays;
import java.util.List;

/**
 * Through this class can be built script blocks of object type.
 *
 * OUTPUT EXAMPLE:
 *
 * NAME: { BODY }
 *
 * @author Martin Linha
 */
public class ObjectBlock extends Property {

    private static final String PREFIX = "{";
    private static final String SUFFIX = "}";

    public ObjectBlock() {
    }

    /**
     * Constructs new empty object block and assigns specified listeners.
     *
     * @param listeners Listener list to be set
     */
    public ObjectBlock(List<ChangeListener> listeners) {
        super(listeners);
    }

    /**
     * Constructs new object block with specified NAME and BODY. Example of output:
     *
     * NAME: { BODY }
     *
     * @param name Name of object block
     * @param body Body of object block
     */
    public ObjectBlock(String name, String body) {
        setName(name);
        setBody(body);
    }

    /**
     * Constructs new empty object block and adds specified elements to object's children collection.
     *
     *
     * @param properties Properties to be added to object's children collection
     */
    public ObjectBlock(Property... properties) {
        addChildren(Arrays.asList(properties));
    }

    /**
     * Constructs new object block with specified NAME and adds specified elements to object's children collection. Example of output:
     *
     * NAME: { PROPERTIES... }
     *
     * @param name Name of object block
     * @param properties Properties to be added to object's children collection
     *
     */
    public ObjectBlock(String name, Property... properties) {
        setName(name);
        addChildren(Arrays.asList(properties));
    }

    /**
     * Constructs new object block with specified BODY. Example of output:
     *
     * { BODY }
     *
     * @param body Body of object block
     */
    public ObjectBlock(String body) {
        setBody(body);
    }

    @Override
    public String getPrefix() {
        return PREFIX;
    }

    @Override
    public String getSuffix() {
        return SUFFIX;
    }
}
