package com.sokolov.task2.validator;

public class IdValueValidator {
    private static final String REGEX = "\\w{1,20}";

    public static boolean validateIdValue (String id) {
        return id.matches(REGEX);
    }
}
