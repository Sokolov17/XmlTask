package com.sokolov.task2.entity;

import com.sokolov.task2.entity.type.Theme;
import com.sokolov.task2.entity.type.Valuable;

import java.time.LocalDate;
import java.util.Objects;

public class GreetingPostcard extends RegularPostcard {
    private String type;

    public GreetingPostcard(String author, String id, String theme, String country, LocalDate realeaseDate, boolean isSent, String valuable, String type) {
        super(author, id, theme, country, realeaseDate, isSent, valuable);
        this.type = type;
    }

    public GreetingPostcard(String id, String theme, String country, LocalDate realeaseDate, boolean isSent, String valuable, String type) {
        super(id, theme, country, realeaseDate, isSent, valuable);
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {           //// FIXME: 18.07.2021
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GreetingPostcard that = (GreetingPostcard) o;
        boolean flag = super.equals(that)
                && (this.type != null && this.type.equals(that.type));
        return  flag;
    }

    @Override
    public int hashCode() {             //// TODO: 18.07.2021
        return Objects.hash(super.hashCode(), type);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append(", type ").append(type);
        return stringBuilder.toString();
    }
}
