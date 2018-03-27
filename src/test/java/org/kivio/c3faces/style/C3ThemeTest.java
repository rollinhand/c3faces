package org.kivio.c3faces.style;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class C3ThemeTest {
    protected static final C3Color ONE = new C3Color("#000");
    protected static final C3Color TWO = new C3Color("#111");
    protected static final C3Color THREE = new C3Color("#222");
    protected static final C3Color FOUR = new C3Color("#333");
    protected static final C3Color FIVE = new C3Color("#444");
    protected static final C3Color SIX = new C3Color("#555");
    protected static final C3Color SEVEN = new C3Color("#666");
    protected static final C3Color EIGHT = new C3Color("#777");

    @Test
    public void testUniqueness() {
        C3Theme theme = new C3Theme("Test",
                new C3Color[]{ONE, TWO, THREE, THREE, FOUR, FIVE, ONE});
        assertNotNull(theme.getPalette());
        assertThat(theme.size(), is(5));
    }

    @Test
    public void testGetIndex() {
        C3Theme theme = new C3Theme("Test",
                new C3Color[]{ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT});

        assertNotNull(theme.getPalette());
        assertThat(theme.size(), is(8));

        assertThat(theme.getColor(0), is(ONE));
        assertThat(theme.getColor(1), is(TWO));
        assertThat(theme.getColor(2), is(THREE));
        assertThat(theme.getColor(3), is(FOUR));
        assertThat(theme.getColor(4), is(FIVE));
        assertThat(theme.getColor(5), is(SIX));
        assertThat(theme.getColor(6), is(SEVEN));
        assertThat(theme.getColor(7), is(EIGHT));

        // If index is larger than palette it should start from the beginning
        assertThat(theme.getColor(8), is(ONE));
        assertThat(theme.getColor(15), is(EIGHT));
        assertThat(theme.getColor(23), is(EIGHT));

        // negative values must be handled like positive ones
        assertThat(theme.getColor(-1), is(TWO));
    }

    @Test
    public void testEmptyArray() {
        C3Theme theme = new C3Theme("Test", new C3Color[]{});
        assertNotNull(theme.getPalette());
        assertThat(theme.size(), is(0));

        assertThat(theme.getColor(1), nullValue());
    }

    @Test
    public void testThemeLarissa() {
        assertNotNull(C3Theme.LARISSA.getPalette());
        assertThat(C3Theme.LARISSA.size(), is(8));
    }

    @Test
    public void testThemeGreyScale() {
        assertNotNull(C3Theme.GREYSCALE.getPalette());
        assertThat(C3Theme.GREYSCALE.size(), is(8));
    }

    @Test
    public void testThemeWarmBlue() {
        assertNotNull(C3Theme.WARM_BLUE.getPalette());
        assertThat(C3Theme.WARM_BLUE.size(), is(8));
    }

    @Test
    public void testThemeYellow() {
        assertNotNull(C3Theme.YELLOW.getPalette());
        assertThat(C3Theme.YELLOW.size(), is(8));
    }

    @Test
    public void testThemePaper() {
        assertNotNull(C3Theme.PAPER.getPalette());
        assertThat(C3Theme.PAPER.size(), is(8));
    }
}
