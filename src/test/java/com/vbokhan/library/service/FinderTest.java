package com.vbokhan.library.service;

import com.vbokhan.library.entity.Book;
import com.vbokhan.library.entity.Magazine;
import com.vbokhan.library.entity.Newspaper;
import com.vbokhan.library.enums.AgeCategory;
import com.vbokhan.library.enums.Genre;
import com.vbokhan.library.enums.Periodicity;
import com.vbokhan.library.interfaces.Issue;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by vbokh on 06.06.2017.
 */
public class FinderTest {
    private static List<Issue> testIssues;

    @BeforeClass
    public static void init() {
        testIssues = new ArrayList<>();
        testIssues.add(new Book("Three Comrades", 322, Genre.NOVEL, "Erich Maria Remarque"));
        testIssues.add(new Book("Three Mushketeers", 300, Genre.NOVEL, "Alexandre Dumas"));
        testIssues.add(new Newspaper("Times", 30, Periodicity.WEEKLY));
        testIssues.add(new Newspaper("The Guardian", 20, Periodicity.MONTHLY));
        testIssues.add(new Magazine("Time", 100, AgeCategory.ADULTS));
        testIssues.add(new Magazine("Funny pictures", 100, AgeCategory.CHILDREN));
        testIssues.add(new Book("Capitan's daughter", 150, Genre.HISTORICAL, "Alexandre Pushkin"));
        testIssues.add(new Book("Статский советник", 315, Genre.DETECTIVE, "Boris Akunin"));
        testIssues.add(new Book("The Count of Monte Cristo", 560, Genre.ADVENTURE, "Alexandre Dumas"));
    }

    @Test
    public void findByNumberOfPagesTest() throws Exception {
        List<Issue> expected = new ArrayList<>();
        expected.add(new Book("Three Comrades", 322, Genre.NOVEL, "Erich Maria Remarque"));
        expected.add(new Book("Three Mushketeers", 300, Genre.NOVEL, "Alexandre Dumas"));
        expected.add(new Book("Статский советник", 315, Genre.DETECTIVE, "Boris Akunin"));
        List<Issue> actual = Finder.findByNumberOfPages(testIssues, 300, 400);
        assertEquals(expected,actual);
    }

    @Test
    public void findIssueByPreciseName() throws Exception {
        List<Issue> expected = new ArrayList<>();
        expected.add(new Book("Three Comrades", 322, Genre.NOVEL, "Erich Maria Remarque"));
        List<Issue> actual = Finder.findIssueByPreciseName(testIssues, "Three Comrades");
        assertEquals(expected,actual);
    }

    @Test
    public void findIssueByPartialName() throws Exception {
        List<Issue> expected = new ArrayList<>();
        expected.add(new Book("Three Comrades", 322, Genre.NOVEL, "Erich Maria Remarque"));
        expected.add(new Book("Three Mushketeers", 300, Genre.NOVEL, "Alexandre Dumas"));
        List<Issue> actual = Finder.findIssueByPartialName(testIssues, "Three");
    }

}