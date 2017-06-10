package com.vbokhan.library.parser;

import com.vbokhan.library.exception.WrongDataException;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * Created by vbokh on 05.06.2017.
 */
public class IssueParserTest {
    private static List<List<String>> expected;
    private static Optional<List<String>> dataForParsing;
    private static Optional<List<String>> nullList;
    private static Optional<List<String>> emptyList;
    private static IssueParser issueParser;
    private static final String TEST_STRING1 = "Book \"Three Comrades\" 322 novel \"Erich Maria Remarque\"";
    private static final String TEST_STRING2 = "Magazine \"Time\" 100 adults";

    @BeforeClass
    public static void init() {
        issueParser = new IssueParser();
        expected = new ArrayList<>();
        nullList = Optional.ofNullable(null);
        emptyList = Optional.of(new ArrayList<>());
        dataForParsing = Optional.of(new ArrayList<>());
        dataForParsing.get().add(TEST_STRING1);
        dataForParsing.get().add(TEST_STRING2);
        List<String> expectedData = new LinkedList<>();
        expectedData.add("Book");
        expectedData.add("Three Comrades");
        expectedData.add("322");
        expectedData.add("novel");
        expectedData.add("Erich Maria Remarque");
        List<String> expectedData1 = new LinkedList<>();
        expectedData1.add("Magazine");
        expectedData1.add("Time");
        expectedData1.add("100");
        expectedData1.add("adults");
        expected.add(expectedData);
        expected.add(expectedData1);
    }

    @Test
    public void parseDataTest() throws Exception {
        List<LinkedList<String>> actual = issueParser.parseData(dataForParsing);
        assertEquals(expected, actual);
    }

    @Test(expected = WrongDataException.class)
    public void nullTest() throws WrongDataException {
        issueParser.parseData(nullList);
    }

    @Test(expected = WrongDataException.class)
    public void emptyListTest() throws WrongDataException {
        issueParser.parseData(emptyList);
    }


}