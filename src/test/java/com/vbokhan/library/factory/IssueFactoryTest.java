package com.vbokhan.library.factory;

import com.vbokhan.library.entity.Book;
import com.vbokhan.library.entity.Magazine;
import com.vbokhan.library.entity.Newspaper;
import com.vbokhan.library.enums.AgeCategory;
import com.vbokhan.library.enums.Genre;
import com.vbokhan.library.enums.Periodicity;
import com.vbokhan.library.interfaces.Issue;
import com.vbokhan.library.parser.Parser;
import com.vbokhan.library.reader.Reader;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by vbokh on 05.06.2017.
 */
public class IssueFactoryTest {
    private static List<Issue> testIssues;
    private static Reader reader;
    private static Parser parser;
    private static IssueFactory factory;
    private final static String FILE_NAME = "src/main/resources/data.txt";

    @BeforeClass
    public static void init() {
        testIssues = new ArrayList<>();
        reader = new Reader();
        parser = new Parser();
        factory = new IssueFactory();
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
    public void createIssue() throws Exception {
        List<Issue> actual = factory.createIssue(parser.parseData(reader.readDataFromFile(FILE_NAME)));
        assertEquals(testIssues, actual);
    }


}