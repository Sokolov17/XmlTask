package com.sokolov.task2.entity;

import com.sokolov.task2.entity.type.Theme;
import com.sokolov.task2.entity.type.Valuable;

import java.time.LocalDate;

public class RegularPostcard {
    private String author;
    private String id;
    private String theme;
    private String country;
    private LocalDate realeaseDate;
    private boolean isSent;
    private String valuable;

    public RegularPostcard(String author, String id, String theme, String country, LocalDate realeaseDate, boolean isSent, String valuable) {
        this.author = author;
        this.id = id;
        this.theme = theme;
        this.country = country;
        this.realeaseDate = realeaseDate;
        this.isSent = isSent;
        this.valuable = valuable;
    }

    public RegularPostcard(String id, String theme, String country, LocalDate realeaseDate, boolean isSent, String valuable) {
        this.id = id;
        this.theme = theme;
        this.country = country;
        this.realeaseDate = realeaseDate;
        this.isSent = isSent;
        this.valuable = valuable;
    }

    @Override
    public boolean equals(Object o) {              //// TODO: 18.07.2021
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegularPostcard that = (RegularPostcard) o;
        boolean flag = (this.author != null && this.author.equals(that.author))
                && (this.id != null && this.id.equals(that.id))
                && (this.theme != null && this.theme.equals(that.theme))
                && (this.country != null && this.country.equals(that.country))
                && (this.realeaseDate != null && this.realeaseDate.equals(that.realeaseDate))
                && (this.isSent == that.isSent)
                && (this.valuable != null && this.valuable.equals(that.valuable));

        return flag;
    }

    @Override
    public int hashCode() {         //// FIXME: 18.07.2021
        return 1;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("author ").append(author);
        stringBuilder.append(", id").append(id);
        stringBuilder.append(", theme").append(theme);
        stringBuilder.append(", country").append(country);
        stringBuilder.append(", realeseDate").append(realeaseDate);
        stringBuilder.append(", isSent").append(isSent);
        stringBuilder.append(", valuable").append(valuable);
        return stringBuilder.toString();
    }
}
