package com.vbokhan.library.enums;

/**
 * Created by vbokh on 04.06.2017.
 */
public enum  AgeCategory {
    CHILDREN("Children", 0,17), ADULTS("Adults",18,150);
    private String categoryName;
    private int ageFrom;
    private int ageTo;

    AgeCategory(String categoryName, int ageFrom, int ageTo) {
        this.categoryName = categoryName;
        this.ageFrom = ageFrom;
        this.ageTo = ageTo;
    }

    @Override
    public String toString() {
        return categoryName +
                " (" + ageFrom +
                "-" + ageTo + ")";
    }
}
