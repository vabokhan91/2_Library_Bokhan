package com.vbokhan.library.interfaces;

import com.vbokhan.library.generator.IdGenerator;

/**
 * Created by vbokh on 03.06.2017.
 */
public abstract class Issue {
    private String name;
    private Integer numberOfPages;
    private Integer id;

    public Issue(String name, Integer numberOfPages) {
        this.id = IdGenerator.nextId();
        this.name = name;
        this.numberOfPages = numberOfPages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", numberOfPages=" + numberOfPages;
    }
}
