package com.vbokhan.library.entity;

/**
 * Created by vbokh on 03.06.2017.
 */
public class Newspaper extends Issue {
    private Periodicity periodicity;

    public Newspaper(String name, Integer numberOfPages, Periodicity periodicity) {
        super(name, numberOfPages);
        this.periodicity = periodicity;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Newspaper{ id = " + getId() + super.toString() +
                ", periodicity = " + periodicity +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Newspaper newspaper = (Newspaper) o;

        return getPeriodicity() == newspaper.getPeriodicity();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getPeriodicity() != null ? getPeriodicity().hashCode() : 0);
        return result;
    }
}
