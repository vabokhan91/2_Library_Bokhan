package com.vbokhan.library.service;

import com.vbokhan.library.enums.Genre;
import com.vbokhan.library.factory.IssueFactory;
import com.vbokhan.library.interfaces.Issue;
import com.vbokhan.library.parser.Parser;
import com.vbokhan.library.reader.Reader;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by vbokh on 04.06.2017.
 */
public class CalculatorTest {
    private static Integer numberOfNovelPages = 622;
    private static Reader reader;
    private static Parser parser;
    private static IssueFactory factory;
    private static final String FILE_NAME = "src/main/resources/data.txt";

    @BeforeClass
    public static void init() {
        reader = new Reader();
        parser = new Parser();
        factory = new IssueFactory();
    }

    @Test
    public void calculatePagesByGenreTest() throws Exception {
        List<String> dataFromFile = reader.readDataFromFile(FILE_NAME);
        List<LinkedList<String>> parsedData = parser.parseData(dataFromFile);
        List<Issue> issues = factory.createIssue(parsedData);

        Integer actual = Calculator.calculatePagesByGenre(issues, Genre.NOVEL);
        assertEquals(numberOfNovelPages, actual);
    }

}