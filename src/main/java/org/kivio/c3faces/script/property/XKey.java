package org.kivio.c3faces.script.property;

import org.kivio.c3faces.script.ValueBlock;

/**
 * Through this class it is possible to specify the x values in the data.
 * This can help to dynamically reload and resize categories.
 *
 * @author Björn Berg
 */
public class XKey extends ValueBlock {
    public static String NAME = "x";

    public XKey(String body) {
        super(body);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public boolean isBodyQuoted() {
        return true;
    }
}
