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
package org.kivio.c3faces.style;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Defines a palette of colors and gives the ability to create new colors.
 *
 * @author Björn Berg, rollin.hand@gmx.de
 * @since 2018-03-04
 * @version 1.0
 */
public class C3Color {
    public static final C3Color GREY_BLUE = new C3Color("#44546a");
    public static final C3Color LIGHT_GREY = new C3Color("#e7e6e6");
    public static final C3Color BLUE = new C3Color("#5b9bd5");
    public static final C3Color ORANGE = new C3Color("#ed7d31");
    public static final C3Color GREY = new C3Color("#a5a5a5");
    public static final C3Color WARM_YELLOW = new C3Color("#ffc000");
    public static final C3Color LIGHT_BLUE = new C3Color("#4472c4");
    public static final C3Color GREEN = new C3Color("#70ad47");
    public static final C3Color BLACK = new C3Color("#000000");
    public static final C3Color MIDNIGHT = new C3Color("#242852");
    public static final C3Color SEAGREEN = new C3Color("#5aa2ae");
    public static final C3Color DARK_BROWN = new C3Color("#39302a");
    public static final C3Color BROWN = new C3Color("#4e3b30");
    public static final C3Color LIGHT_BROWN = new C3Color("#865640");
    public static final C3Color RED = new C3Color("#b22600");


    private String hexCode;
    private Object obj;

    /**
     * Creates a new {@link C3Color} from hex code.
     * A hex code must be of form #ABC or #ABCDEFG. Other formatted inputs are not allowed.
     * @param hexCode
     */
    public C3Color(String hexCode) {
        // Validate input
        if (StringUtils.isNotEmpty(hexCode) &&
                hexCode.matches("#([0-9A-Fa-f]{3}|[0-9A-Fa-f]{6})")) {
            this.hexCode = hexCode;
        } else {
            throw new IllegalArgumentException(hexCode + " is not a valid input");
        }
    }

    /**
     * Returns the hex code of this color.
     * @return hex code.
     */
    public String getHexCode() {
        return hexCode;
    }

    @Override
    public String toString() {
        return getHexCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        C3Color c3Color = (C3Color) o;

        return new EqualsBuilder()
                .append(hexCode, c3Color.hexCode)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(hexCode)
                .toHashCode();
    }
}
