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
package org.kivio.c3faces.util;

/**
 * Class contains useful static methods for UI components.
 *
 * @author Martin Linha
 */
public class ComponentUtil {

    /**
     * Tries to parse specified object to boolean. If object is null, returns null.
     *
     * @param o Object to be parsed
     * @return Parsed object or null
     */
    public static Boolean parseBoolean(Object o) {
        if (o == null) {
            return null;
        }
        return Boolean.parseBoolean((String) o);
    }

    /**
     * Tries to parse specified object to integer. If object is null, returns null.
     *
     * @param o Object to be parsed
     * @return Parsed object or null
     */
    public static Integer parseInteger(Object o) {
        if (o == null) {
            return null;
        }
        return Integer.parseInt((String) o);
    }

    /**
     * Tries to parse specified object to double. If object is null, returns null.
     *
     * @param o Object to be parsed
     * @return Parsed object or null
     */
    public static Double parseDouble(Object o) {
        if (o == null) {
            return null;
        }
        return Double.parseDouble((String) o);
    }

    /**
     * Tries to find Enum of specified name in specified class. If name's null, returns null.
     *
     * @param <E>
     * @param clazz
     * @param name
     * @return Parsed object or null
     */
    public static <E extends Enum<E>> E findEnum(Class<E> clazz, String name) {
        if (name == null) {
            return null;
        }
        try {
            return Enum.valueOf(clazz, name.toUpperCase());
        } catch (IllegalArgumentException iae) {
            return null;
        }
    }
}
