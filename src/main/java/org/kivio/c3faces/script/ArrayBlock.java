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

import java.util.Arrays;

/**
 * Through this class can be built script blocks of array type.
 *
 * OUTPUT EXAMPLE:
 *
 * NAME: [BODY]
 *
 * @author Martin Linha
 */
public class ArrayBlock extends Property {

    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";

    public ArrayBlock() {
    }

    /**
     * Constructs new array block with specified NAME and BODY. Example of output:
     *
     * NAME: [BODY]
     *
     * @param name Name of array block
     * @param body Body of array block
     */
    public ArrayBlock(String name, String body) {
        setName(name);
        setBody(body);
    }

    /**
     * Constructs new array block with specified NAME and properties. Example of output:
     *
     * NAME: [PROPERTIES...]
     *
     * @param name Name of array block
     * @param properties Properties to be added in body
     */
    public ArrayBlock(String name, Property... properties) {
        setName(name);
        addChildren(Arrays.asList(properties));
    }

    /**
     * Constructs new array block with specified BODY. Example of output:
     *
     * [BODY]
     *
     * @param body Body of array block
     */
    public ArrayBlock(String body) {
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
