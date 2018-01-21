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

import org.kivio.c3faces.script.MethodBlock;

/**
 * Objects represents Onmouseout .js event and javascript function to be evaluated when this .js event is fired. Can be used only at places which defines
 * C3.js.
 *
 * @author Martin Linha
 */
public class OnmouseoutMethod extends MethodBlock {

    public OnmouseoutMethod(String body, String... params) {
        super(body, params);
    }

    @Override
    public String getName() {
        return "onmouseout";
    }

}
