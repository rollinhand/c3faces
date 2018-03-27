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

import java.util.*;

public class C3Theme {
    /**
     * The default theme like in Microsoft Excel or OpenOffice Calc.
     */
    public static final C3Theme LARISSA = new C3Theme("Larissa",
            new C3Color[]{
            C3Color.GREY_BLUE, C3Color.LIGHT_GREY, C3Color.BLUE, C3Color.ORANGE,
            C3Color.GREY, C3Color.WARM_YELLOW, C3Color.LIGHT_BLUE, C3Color.GREEN
    });

    /**
     * A balanced monochrome theme.
     */
    public static final C3Theme GREYSCALE = new C3Theme("GreyScale",
            new C3Color[]{
            C3Color.BLACK, new C3Color("#f8f8f8"), C3Color.LIGHT_GREY,
            new C3Color("#b2b2b2"), new C3Color("#969696"),
            new C3Color("#808080"), new C3Color("#5f5f5f"),
            new C3Color("#4d4d4d")
    });

    /**
     * A balanced warm blue tone theme.
     */
    public static final C3Theme WARM_BLUE = new C3Theme("WarmBlue",
            new C3Color[]{
            C3Color.MIDNIGHT, new C3Color("#accbf9"),
            new C3Color("#4a66ac"), new C3Color("#629dd1"),
            new C3Color("#297fd5"), new C3Color("#7f8fa9"),
            C3Color.SEAGREEN, new C3Color("#9d90a0")
    });

    /**
     * A theme based on complementary of yellow.
     */
    public static final C3Theme YELLOW = new C3Theme("Yellow",
            new C3Color[] {
            C3Color.DARK_BROWN, C3Color.LIGHT_GREY, C3Color.WARM_YELLOW, C3Color.ORANGE,
            new C3Color("#ce8d3e"), new C3Color("#ec7016"),
            new C3Color("#e64823"), new C3Color("#9c6a6a")
    });

    /**
     * A theme based on pastel colors.
     */
    public static final C3Theme PAPER = new C3Theme("Paper", new C3Color[] {
            new C3Color("#444d26"), new C3Color("#fefac9"),
            new C3Color("#a5b592"), new C3Color("#f3a447"),
            new C3Color("#e7bc29"), new C3Color("#d092a7"),
            new C3Color("#9c85c0"), new C3Color("#809ec2"),
    });

    private C3Color[] colorSet;
    private String name;

    /**
     * Creates a new theme from an array of defined colors.
     * @param colors an array of {@link C3Color}.
     */
    public C3Theme(final String name, final C3Color[] colors) {
        this(name, Arrays.asList(colors));
    }

    /**
     * Creates a new theme from a list of defined colors.
     * @param colors a list of {@link C3Color}.
     */
    public C3Theme(final String name, final List<C3Color> colors) {
        // Make the palette unique - otherwise there is no harmony
        Set<C3Color> uniqueSet = new LinkedHashSet<>(colors);
        colorSet = uniqueSet.toArray(new C3Color[uniqueSet.size()]);
        this.name = name;
    }

    /**
     * Returns the color from the defined palette by its numeric index.
     * Index starts by 0 and function returns appropriate color. If a negative index
     * is provided the method gets the abs() value of it.
     *
     * @param index starting by 0.
     * @return at the index defined color.
     */
    public C3Color getColor(final int index) {
        if (colorSet.length == 0) {
            return null;
        }

        return colorSet[((Math.abs(index) >= colorSet.length) ?
                         (Math.abs(index) % colorSet.length) : Math.abs(index))];
    }

    /**
     * Returns the number of defined colors in this theme.
     * @return number of defined colors.
     */
    public int size() {
        return colorSet.length;
    }

    /**
     * Returns all available colors in the right order.
     * @return colors as array.
     */
    protected final C3Color[] getPalette() {
        return colorSet;
    }

    /**
     * Returns the individual name of the theme.
     * @return name of theme.
     */
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
