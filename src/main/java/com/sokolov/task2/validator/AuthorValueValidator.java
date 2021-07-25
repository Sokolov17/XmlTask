package com.sokolov.task2.validator;

public class AuthorValueValidator {
    private static final String REGEX = "[a-zA-Z]{2,}";

    public static boolean validateAuthorValue(String author) {
        return author.matches(REGEX);
    }
}
