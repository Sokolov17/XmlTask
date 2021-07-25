package com.sokolov.task2.entity.type;

import java.util.Locale;

public enum PostcardType {
    REGULAR_POSTCARD,
    PROMOTIONAL_POSTCARD,
    GREETING_POSTCARD;

    @Override
    public String toString() {
        return name().toLowerCase().replaceAll("_", "-");
    }
}
