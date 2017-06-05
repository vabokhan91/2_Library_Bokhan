package com.vbokhan.library.enums;

/**
 * Created by vbokh on 04.06.2017.
 */
public enum Periodicity {
    DAILY("Daily"), WEEKLY("Weekly"), MONTHLY("Monthly");

    private String periodicity;

    Periodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return periodicity;
    }
}
