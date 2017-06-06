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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Issue issue = (Issue) o;

        if (getName() != null ? !getName().equals(issue.getName()) : issue.getName() != null) return false;
        return getNumberOfPages() != null ? getNumberOfPages().equals(issue.getNumberOfPages()) : issue.getNumberOfPages() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getNumberOfPages() != null ? getNumberOfPages().hashCode() : 0);
        return result;
    }
}
