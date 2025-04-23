package com.grech.constants;

import java.util.regex.Pattern;

public final class Constants {
    public static final int COMMAND_TYPE_ARG_POSITION = 0;
    public static final int FILE_ARG_POSITION = 1;
    public static final int KEY_ARG_POSITION = 2;
    public static final int ZERO_ARGS_COUNT = 0;
    public static final int MIN_ALLOWED_ARGS_COUNT = 2;
    public static final int MAX_ALLOWED_ARGS_COUNT = 3;
    public static final int DEFAULT_KEY = 0;
    public static final String EN_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz.,«»\"':!? ";
    public static final Pattern VALID_TEXT_PATTERN = Pattern.compile(".*( the | and | is | of | to | in | that | it | for | on ).*");
}
