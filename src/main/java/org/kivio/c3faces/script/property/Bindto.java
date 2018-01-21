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
package org.kivio.c3faces.script.property;

import org.kivio.c3faces.script.ValueBlock;

/**
 * Through this class is possible to define div to which chart will be appended.
 * 
 * NOTE: mainly used for internal reasons of C3Faces (C3Chart components used their unique div id)
 *
 * @author Martin Linha
 */
public class Bindto extends ValueBlock {

    public static String NAME = "bindto";

    public Bindto(String body) {
        super(body);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public boolean isBodyQuoted() {
        return true;
    }
}
