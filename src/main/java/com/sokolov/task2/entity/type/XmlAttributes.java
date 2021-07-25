package com.sokolov.task2.entity.type;

public enum XmlAttributes {
    AUTHOR("Author"),
    ID("id");

    private String value;

    XmlAttributes(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
