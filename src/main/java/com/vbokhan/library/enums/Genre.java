package com.vbokhan.library.enums;

/**
 * Created by vbokh on 03.06.2017.
 */
public enum Genre {
    DETECTIVE("Detective"), NOVEL("Novel"), HISTORICAL("Historical"), ADVENTURE("Adventure"), FANTASY("Fantasy"), FAIRY_TALE("Fairytale");

    private String nameOfGenre;

    Genre(String nameOfGenre) {
        this.nameOfGenre = nameOfGenre;
    }

    @Override
    public String toString() {
        return nameOfGenre;
    }
}
