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

import org.kivio.c3faces.script.ObjectBlock;
import org.kivio.c3faces.script.ValueBlock;

/**
 * Through this class is possible to specify if interaction of chart should be enabled. Mainly used for internal reasons.
 *
 *
 * @author Martin Linha
 */
public class Interaction extends ObjectBlock {

    public static String NAME = "interaction";

    private Boolean enabled;

    public Interaction() {
    }

    public Interaction(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    protected void preScriptBuild() {
        if (enabled != null) {
            addChild(new ValueBlock("enabled", enabled));
        }
    }

    @Override
    public String getName() {
        return NAME;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
