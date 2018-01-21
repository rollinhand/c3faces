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

/**
 * Through this class can be built script blocks of value type separated by comma, name and body are quoted. OUTPUT EXAMPLE:
 *
 * 'NAME', 'BODY'
 *
 * @author Martin Linha
 */
public class CommaValueBlock extends ValueBlock {

    /**
     * Constructs new comma value block with specified NAME and BODY. Both can be quoted. Example of output:
     *
     * 'NAME', 'BODY'
     *
     * @param name Name of array block
     * @param body Body of array block
     * @param bodyQuoted True if body should be quoted
     * @param nameQuoted True if name should be quoted
     */
    public CommaValueBlock(String name, String body, boolean bodyQuoted, boolean nameQuoted) {
        super(name, body, bodyQuoted, nameQuoted);
    }

    @Override
    public boolean isBodyQuoted() {
        return true;
    }

    @Override
    public boolean isNameQuoted() {
        return true;
    }

    @Override
    public String getSeparator() {
        return ", ";
    }
}
