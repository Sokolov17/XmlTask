package com.sokolov.task2.entity.type;

public enum Valuable {
    THEMATHIC("Themathic"),
    HISTORICAL("Historical"),
    COLLECTIBLE("Collectible");


    private String value;

    Valuable(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
