package com.vbokhan.library.parser;

import com.vbokhan.library.exception.MissingDataException;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by vbokh on 05.06.2017.
 */
public class ParserTest {
    private static List<List<String>> expected;
    private static List<String> dataForParsing;
    private static List<String> nullList ;
    private static List<String> emptyList;
    private static Parser parser;
    private final static String stringForTesting = "Book \"Three Comrades\" 322 novel \"Erich Maria Remarque\"";
    private final static String stringForTesting2 = "Magazine \"Time\" 100 adults";
    private final static String wrongStringForTesting3 = "Newspaper \"SomeName\" 40 wrongPeriodicity";

    @BeforeClass
    public static void init() {
        parser = new Parser();
        expected = new ArrayList<>();
        nullList = null;
        emptyList = new ArrayList<>();
        dataForParsing = new LinkedList<>();
        dataForParsing.add(stringForTesting);
        dataForParsing.add(stringForTesting2);
        dataForParsing.add(wrongStringForTesting3);
        List<String> list1 = new LinkedList<>();
        list1.add("Book");
        list1.add("Three Comrades");
        list1.add("322");
        list1.add("novel");
        list1.add("Erich Maria Remarque");
        List<String> list2 = new LinkedList<>();
        list2.add("Magazine");
        list2.add("Time");
        list2.add("100");
        list2.add("adults");
        expected.add(list1);
        expected.add(list2);
    }

    @Test
    public void parseDataTest() throws Exception {
        List<LinkedList<String>> actual = parser.parseData(dataForParsing);
        assertEquals(expected, actual);
    }

    @Test(expected = MissingDataException.class)
    public void nullTest() throws MissingDataException{
        parser.parseData(nullList);
    }

    @Test(expected = MissingDataException.class)
    public void emptyListTest() throws MissingDataException{
        parser.parseData(emptyList);
    }


}