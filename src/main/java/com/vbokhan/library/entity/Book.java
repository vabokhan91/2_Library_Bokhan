package com.vbokhan.library.entity;

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
        return "Book{ id = " + getId() +
                super.toString() + "," +
                " genre = " + genre +
                ", author = '" + author + '\'' +
                "} ";
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Book book = (Book) o;

        if (getGenre() != book.getGenre()) return false;
        return getAuthor() != null ? getAuthor().equals(book.getAuthor()) : book.getAuthor() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getGenre() != null ? getGenre().hashCode() : 0);
        result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        return result;
    }
}
