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
 * Through this class is possible to specify the duration of transition animations.
 *
 * NOTE: Mainly used for internal reasons. The duration is setted by C3Chart, so all C3Charts subtypes inherits it.
 *
 * @author Martin Linha
 */
public class Transition extends ObjectBlock {

    public static String NAME = "transition";

    private Integer duration;

    public Transition() {
    }

    public Transition(Integer duration) {
        this.duration = duration;
    }

    @Override
    protected void preScriptBuild() {
        addChild(new ValueBlock("duration", duration));
    }

    @Override
    public String getName() {
        return NAME;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
