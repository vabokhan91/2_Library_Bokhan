package com.vbokhan.library.entity;

import com.vbokhan.library.enums.Genre;
import com.vbokhan.library.interfaces.Issue;

/**
 * Created by vbokh on 03.06.2017.
 */
public class Book extends Issue {
    private Genre genre;
    private String author;

    public Book(String name, Integer numberOfPages, Genre genre, String author) {
        super(name, numberOfPages);
        this.genre = genre;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{ id= " + getId() + " " +
                super.toString() + "," +
                " genre=" + genre +
                ", author='" + author + '\'' +
                "} " ;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
