package com.vbokhan.library.entity;

import com.vbokhan.library.enums.Periodicity;
import com.vbokhan.library.generator.IdGenerator;
import com.vbokhan.library.interfaces.Issue;

/**
 * Created by vbokh on 03.06.2017.
 */
public class Newspaper extends Issue {
    private int id;
    private Periodicity periodicity;

    public Newspaper(String name, Integer numberOfPages, Periodicity periodicity) {
        super(name, numberOfPages);
        this.periodicity = periodicity;
        this.id = IdGenerator.nextId();
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Newspaper{ id= " + id +" " + super.toString() + " " +
                "periodicity=" + periodicity +
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
