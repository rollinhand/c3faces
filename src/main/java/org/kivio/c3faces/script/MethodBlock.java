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

import org.kivio.c3faces.util.JSTools;
import java.util.Arrays;

/**
 * Through this class can be built script blocks similar to Javascript function blocks. Name corresponds to function name, body to body of that
 * function. Can also contain function parameters. OUTPUT EXAMPLE:
 *
 * NAME: function (PARAM1, PARAM2) { BODY }
 *
 * @author Martin Linha
 */
public class MethodBlock extends Property {

    private final String[] params;

    /**
     * Constructs new .js function with event name, body including .js script and parameters. Example of output:
     *
     * NAME: function (PARAM1, PARAM2) { BODY }
     *
     * @param eventName Name of function
     * @param body Body of array block
     * @param params Function paramaters
     */
    public MethodBlock(String eventName, String body, String... params) {
        setName(eventName);
        setBody(body);
        this.params = params;
    }

    /**
     * Constructs new .js function with body including .js script and parameters. Example of output:
     *
     * function (PARAM1, PARAM2) { BODY }
     *
     * @param body Body of array block
     * @param params Function paramaters
     */
    public MethodBlock(String body, String... params) {
        setBody(body);
        this.params = params;
    }

    @Override
    public String getPrefix() {
        return "function (" + JSTools.commaSeparatedStrings(Arrays.asList(params)) + ") {";
    }

    @Override
    public String getSuffix() {
        return "}";
    }
}
