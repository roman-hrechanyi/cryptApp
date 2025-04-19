package com.grech.utils;

import com.grech.constants.CommandType;

import java.nio.file.Files;
import java.nio.file.Path;

import static com.grech.constants.Constants.MAX_ALLOWED_ARGS_COUNT;
import static com.grech.constants.Constants.MIN_ALLOWED_ARGS_COUNT;

public class ArgsValidator {
    public static boolean isValidArgsCount(String[] args) {
        return (args.length <= MAX_ALLOWED_ARGS_COUNT && args.length >= MIN_ALLOWED_ARGS_COUNT);
    }

    public static boolean isValidCommandType(String commandType) {
        return CommandType.getCommands().contains(commandType);
    }

    public static boolean isValidFilePath(String filePath) {
        return Files.exists(Path.of(filePath));
    }
}
