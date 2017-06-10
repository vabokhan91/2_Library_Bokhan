package com.vbokhan.library.entity;

import com.vbokhan.library.generator.IdGenerator;

/**
 * Created by vbokh on 03.06.2017.
 */
public abstract class Issue {
    private Integer id;
    private String title;
    private Integer numberOfPages;

    public Issue(String name, Integer numberOfPages) {
        this.id = IdGenerator.nextId();
        this.title = name;
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return ", title='" + title + '\'' +
                ", numberOfPages=" + numberOfPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Issue issue = (Issue) o;

        if (getTitle() != null ? !getTitle().equals(issue.getTitle()) : issue.getTitle() != null) return false;
        return getNumberOfPages() != null ? getNumberOfPages().equals(issue.getNumberOfPages()) : issue.getNumberOfPages() == null;
    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + (getNumberOfPages() != null ? getNumberOfPages().hashCode() : 0);
        return result;
    }
}
