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

/**
 * Interface which extends ChangeListener and is implemented by classed which mainly generates C3.js script.
 *
 * @author Martin Linha
 */
public interface PropertyModifier extends ChangeListener {

    /**
     * Returns generated script.
     *
     * @param parent Subject on which should be script executed (mainly .js name of chart's variable)
     * @param duration Duration of animation in millis
     * @return Generated script
     */
    String getScript(String parent, int duration);

    /**
     * Because of class can contains other animations, total duration can be different than script duration.
     *
     * @return Total duration in millis
     */
    int totalDuration();

    /**
     * Method mainly for resetting state of implementing objects.
     *
     */
    void reset();
}
