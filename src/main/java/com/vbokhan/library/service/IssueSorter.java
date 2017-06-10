package com.vbokhan.library.service;

import com.vbokhan.library.entity.Book;
import com.vbokhan.library.entity.Issue;

import java.util.Comparator;
import java.util.List;

/**
 * Created by vbokh on 04.06.2017.
 */
public class IssueSorter {
    public static List<Issue> sortByNameASC(List<Issue> listForSorting) {
        listForSorting.sort(Comparator.comparing(Issue::getTitle));
        return listForSorting;
    }

    public static List<Issue> sortByNameDESC(List<Issue> listForSorting) {
        listForSorting.sort((Issue a1, Issue a2) -> a2.getTitle().compareTo(a1.getTitle()));
        return listForSorting;
    }

    public static List<Issue> sortByNumberOfPagesASC(List<Issue> listForSorting) {
        listForSorting.sort(Comparator.comparing(Issue::getNumberOfPages));
        return listForSorting;
    }

    public static List<Issue> sortByNumberOfPagesDESC(List<Issue> listForSorting) {
        listForSorting.sort((Issue a1, Issue a2) -> a2.getNumberOfPages() - a1.getNumberOfPages());
        return listForSorting;
    }

    public static List<Issue> sortByNameAndPages(List<Issue> listForSorting) {
        listForSorting.sort((Comparator.comparing(Issue::getTitle).thenComparing(Issue::getNumberOfPages)));
        return listForSorting;
    }

    public static List<Book> sortBooksByGenre(List<Book> listForSorting) {
        listForSorting.sort((Book b1, Book b2) -> b1.getGenre().toString().compareTo(b2.getGenre().toString()));
        return listForSorting;
    }
}
