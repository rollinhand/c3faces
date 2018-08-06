/**
 Copyright 2018 Björn Berg

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
package org.kivio.c3faces.model;

import java.util.*;

/**
 * This class allows to define categories for the x or y axis.
 *
 * @author Bjoern Berg, rollin.hand@gmx.de
 * @since 2018-01-21
 */
public class C3CategorySet {
    private final Set<String> values;

    public C3CategorySet(String[] input) {
        this(Arrays.asList(input));
    }

    public C3CategorySet(List<String> input) {
        this.values = Collections.unmodifiableSet(new LinkedHashSet<>(input));
    }

    /**
     * Categories should be unique values.
     * @return set with unique values.
     */
    public Set<String> getValues() {
        return values;
    }
}
