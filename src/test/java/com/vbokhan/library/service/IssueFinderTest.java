package com.vbokhan.library.service;

import com.vbokhan.library.entity.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by vbokh on 06.06.2017.
 */
public class IssueFinderTest {
    private static List<Issue> testIssues;
    private static List<Issue> expected;

    @BeforeClass
    public static void init() {
        expected = new ArrayList<>();
        expected.add(new Book("Three Comrades", 322, Genre.NOVEL, "Erich Maria Remarque"));
        expected.add(new Book("Three Mushketeers", 300, Genre.NOVEL, "Alexandre Dumas"));
        expected.add(new Book("Статский советник", 315, Genre.DETECTIVE, "Boris Akunin"));
        testIssues = new ArrayList<>();
        testIssues.add(new Book("Three Comrades", 322, Genre.NOVEL, "Erich Maria Remarque"));
        testIssues.add(new Book("Three Mushketeers", 300, Genre.NOVEL, "Alexandre Dumas"));
        testIssues.add(new Newspaper("Times", 30, Periodicity.WEEKLY));
        testIssues.add(new Magazine("Time", 100, AgeCategory.ADULTS));
        testIssues.add(new Magazine("Funny pictures", 100, AgeCategory.CHILDREN));
        testIssues.add(new Book("Capitan's daughter", 150, Genre.HISTORICAL, "Alexandre Pushkin"));
        testIssues.add(new Book("Статский советник", 315, Genre.DETECTIVE, "Boris Akunin"));
    }

    @Test
    public void findByNumberOfPagesTest() throws Exception {
        List<Issue> actual = IssueFinder.findByNumberOfPages(testIssues, 300, 400);
        assertEquals(expected, actual);
    }

    @Test
    public void findIssueByPreciseNameTest() throws Exception {
        List<Issue> expected = new ArrayList<>();
        expected.add(new Book("Three Comrades", 322, Genre.NOVEL, "Erich Maria Remarque"));
        List<Issue> actual = IssueFinder.findIssueByPreciseName(testIssues, "Three Comrades");
        assertEquals(expected, actual);
    }

    @Test
    public void findIssueByPartialNameTest() throws Exception {
        List<Issue> expected = new ArrayList<>();
        expected.add(new Book("Three Comrades", 322, Genre.NOVEL, "Erich Maria Remarque"));
        expected.add(new Book("Three Mushketeers", 300, Genre.NOVEL, "Alexandre Dumas"));
        List<Issue> actual = IssueFinder.findIssueByPartialName(testIssues, "Three");
        assertEquals(expected, actual);
    }
}