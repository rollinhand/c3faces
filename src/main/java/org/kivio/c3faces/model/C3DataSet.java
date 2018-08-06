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
package org.kivio.c3faces.model;

import java.util.Collections;
import java.util.List;

/**
 * Class represents series of data units in chart. Once is created, list is unmodifiable. To modify data series, just create new instance of this
 * object.
 *
 * Note that C3.js supports only numeric values, so wrapped collection is of corresponding type.
 *
 * @author Martin Linha
 */
public class C3DataSet {
    private List<? extends Number> values;

    public C3DataSet(List<? extends Number> values) {
        this.values = Collections.unmodifiableList(values);
    }

    /**
     * Return data series.
     *
     * @return Data series
     */
    public List<? extends Number> getValues() {
        return values;
    }
}
