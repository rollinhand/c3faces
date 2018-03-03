package org.kivio.c3faces.constants;

public enum Family {
    PROPERTY("org.kivio.c3faces.component.property");

    private final String familyName;

    Family(String familyName) {
        this.familyName = familyName;
    }


    @Override
    public String toString() {
        return this.familyName;
    }
}
