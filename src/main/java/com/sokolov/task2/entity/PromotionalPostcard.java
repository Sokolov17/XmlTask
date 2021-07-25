package com.sokolov.task2.entity;

import com.sokolov.task2.entity.type.Theme;
import com.sokolov.task2.entity.type.Valuable;

import java.time.LocalDate;
import java.util.Objects;

public class PromotionalPostcard extends RegularPostcard {
    private int telephone;

    public PromotionalPostcard(String author, String id, String theme, String country, LocalDate realeaseDate, boolean isSent, String valuable, int telephone) {
        super(author, id, theme, country, realeaseDate, isSent, valuable);
        this.telephone = telephone;
    }

    public PromotionalPostcard(String id, String theme, String country, LocalDate realeaseDate, boolean isSent, String valuable, int telephone) {
        super(id, theme, country, realeaseDate, isSent, valuable);
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {           //// FIXME: 18.07.2021 
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PromotionalPostcard that = (PromotionalPostcard) o;
        boolean flag = super.equals(that)
                && this.telephone == that.telephone;
        
        return flag;
    }

    @Override
    public int hashCode() {                     //// TODO: 18.07.2021
        return Objects.hash(super.hashCode(), telephone);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append(", telephone ").append(telephone);
        return stringBuilder.toString();

    }
}
