package com.vbokhan.library.service;

import com.vbokhan.library.entity.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by vbokh on 04.06.2017.
 */
public class IssueCalculatorTest {
    private static Integer numberOfNovelPages = 622;
    private static List<Issue> testIssues;

    @BeforeClass
    public static void init() {
        testIssues = new ArrayList<>();
        testIssues.add(new Book("Three Comrades", 322, Genre.NOVEL, "Erich Maria Remarque"));
        testIssues.add(new Book("Three Mushketeers", 300, Genre.NOVEL, "Alexandre Dumas"));
        testIssues.add(new Magazine("Time", 100, AgeCategory.ADULTS));
        testIssues.add(new Magazine("Funny pictures", 100, AgeCategory.CHILDREN));
        testIssues.add(new Book("Capitan's daughter", 150, Genre.HISTORICAL, "Alexandre Pushkin"));
        testIssues.add(new Book("Статский советник", 315, Genre.DETECTIVE, "Boris Akunin"));
    }

    @Test
    public void calculatePagesByGenreTest() throws Exception {
        Integer actual = IssueCalculator.calculatePagesByGenre(testIssues, Genre.NOVEL);
        assertEquals(numberOfNovelPages, actual);
    }
}