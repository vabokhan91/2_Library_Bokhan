package com.vbokhan.library.entity;

/**
 * Created by vbokh on 04.06.2017.
 */
public class Magazine extends Issue {
    private AgeCategory ageCategory;

    public Magazine(String name, Integer numberOfPages, AgeCategory ageCategory) {
        super(name, numberOfPages);
        this.ageCategory = ageCategory;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(AgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }

    @Override
    public String toString() {
        return "Magazine{ id = " + getId() + super.toString() +
                ", ageCategory = " + ageCategory +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Magazine magazine = (Magazine) o;

        return getAgeCategory() == magazine.getAgeCategory();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getAgeCategory() != null ? getAgeCategory().hashCode() : 0);
        return result;
    }
}

