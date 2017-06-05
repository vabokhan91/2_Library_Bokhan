package com.vbokhan.library.enums;

/**
 * Created by vbokh on 03.06.2017.
 */
public enum Genre {
    FICTION("Fiction"), DETECTIVE("Detective");

    private String nameOfGenre;

    Genre(String nameOfGenre) {
        this.nameOfGenre = nameOfGenre;
    }

    @Override
    public String toString() {
        return nameOfGenre;
    }
}
