package com.grech.constants;

import java.util.List;

public enum CommandType {
    ENCRYPT("ENCRYPT"),
    DECRYPT("DECRYPT"),
    BRUTE_FORCE("BRUTE_FORCE");

    private final String displayName;
    private static final List<String> commands;

    static {
        commands = List.of(
                ENCRYPT.toString(),
                DECRYPT.toString(),
                BRUTE_FORCE.toString()
        );
    }

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

    public static List<String> getCommands() {
        return commands;
    }
}
