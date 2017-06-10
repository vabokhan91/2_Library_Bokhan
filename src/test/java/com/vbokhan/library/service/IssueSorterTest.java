package com.vbokhan.library.service;

import com.vbokhan.library.entity.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by vbokh on 06.06.2017.
 */
public class IssueSorterTest {
    private static List<Issue> testListSortingIssues;
    private static List<Book> testListForSortingBooks;

    @BeforeClass
    public static void init() {
        testListSortingIssues = new ArrayList<>();
        testListForSortingBooks = new ArrayList<>();
        testListSortingIssues.add(new Book("Three Comrades", 322, Genre.NOVEL, "Erich Maria Remarque"));
        testListSortingIssues.add(new Book("Three Mushketeers", 300, Genre.NOVEL, "Alexandre Dumas"));
        testListSortingIssues.add(new Newspaper("Times", 30, Periodicity.WEEKLY));
        testListSortingIssues.add(new Newspaper("The Guardian", 20, Periodicity.MONTHLY));
        testListSortingIssues.add(new Magazine("Time", 100, AgeCategory.ADULTS));
        testListSortingIssues.add(new Magazine("Funny pictures", 100, AgeCategory.CHILDREN));
        testListSortingIssues.add(new Book("Capitan's daughter", 150, Genre.HISTORICAL, "Alexandre Pushkin"));
        testListSortingIssues.add(new Book("Capitan's daughter", 130, Genre.HISTORICAL, "Alexandre Pushkin"));
        testListSortingIssues.add(new Book("The Count of Monte Cristo", 560, Genre.ADVENTURE, "Alexandre Dumas"));
        testListForSortingBooks.add(new Book("Three Comrades", 322, Genre.NOVEL, "Erich Maria Remarque"));
        testListForSortingBooks.add(new Book("Three Mushketeers", 300, Genre.NOVEL, "Alexandre Dumas"));
        testListForSortingBooks.add(new Book("Capitan's daughter", 150, Genre.HISTORICAL, "Alexandre Pushkin"));
        testListForSortingBooks.add(new Book("Capitan's daughter", 130, Genre.HISTORICAL, "Alexandre Pushkin"));
        testListForSortingBooks.add(new Book("The Count of Monte Cristo", 560, Genre.ADVENTURE, "Alexandre Dumas"));
    }

    @Before
    public void before() {
        Collections.shuffle(testListSortingIssues);
        Collections.shuffle(testListForSortingBooks);
    }

    @Test
    public void sortByNameASCTest() throws Exception {
        String expected = "Capitan's daughter";
        IssueSorter.sortByNameASC(testListSortingIssues);
        String actual = testListSortingIssues.get(0).getTitle();
        assertEquals(expected, actual);

    }

    @Test
    public void sortByNameDESC() throws Exception {
        String expected = "Times";
        IssueSorter.sortByNameDESC(testListSortingIssues);
        String actual = testListSortingIssues.get(0).getTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void sortByNumberOfPagesASC() throws Exception {
        String expected = "The Guardian";
        IssueSorter.sortByNumberOfPagesASC(testListSortingIssues);
        String actual = testListSortingIssues.get(0).getTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void sortByNumberOfPagesDESC() throws Exception {
        String expected = "The Count of Monte Cristo";
        IssueSorter.sortByNumberOfPagesDESC(testListSortingIssues);
        String actual = testListSortingIssues.get(0).getTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void sortByNameAndPages() throws Exception {
        int expected = 130;
        IssueSorter.sortByNameAndPages(testListSortingIssues);
        int actual = testListSortingIssues.get(0).getNumberOfPages();
        assertEquals(expected, actual);
    }

    @Test
    public void sortBooksByGenre() throws Exception {
        Genre expected = Genre.ADVENTURE;
        IssueSorter.sortBooksByGenre(testListForSortingBooks);
        Genre actual = testListForSortingBooks.get(0).getGenre();
        assertEquals(expected, actual);
    }

}