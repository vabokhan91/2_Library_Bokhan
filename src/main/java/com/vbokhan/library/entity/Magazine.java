package com.vbokhan.library.entity;

import com.vbokhan.library.enums.AgeCategory;
import com.vbokhan.library.generator.IdGenerator;
import com.vbokhan.library.interfaces.Issue;

/**
 * Created by vbokh on 04.06.2017.
 */
public class Magazine extends Issue {
    private int id;
    private AgeCategory ageCategory;

    public Magazine(String name, Integer numberOfPages, AgeCategory ageCategory) {
        super(name, numberOfPages);
        this.ageCategory = ageCategory;
        this.id = IdGenerator.nextId();
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(AgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }

    @Override
    public String toString() {
        return "Magazine{ id = " + id +" " + super.toString() +
                ", ageCategory =" + ageCategory +
                "} " ;
    }


}
