package com.grech.constances;

public enum CommandType {
    ENCRYPT("ENCRYPT"),
    DECRYPT("DECRYPT"),
    BRUTE_FORCE("BRUTE_FORCE");

    private final String displayName;

    CommandType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
