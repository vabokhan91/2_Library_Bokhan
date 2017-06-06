package com.vbokhan.library.reader;

import com.vbokhan.library.exception.NoFileException;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by vbokh on 05.06.2017.
 */
public class ReaderTest {
    private static List<String> listForTestingReader;
    private final static String FILE_NAME = "src/main/resources/data.txt";
    private static Reader reader;
    private static final String EMPTY_STRING = "";
    private static final String NULL_STRING = null;

    @BeforeClass
    public static void init() {
        reader = new Reader();
        listForTestingReader = new ArrayList<>();
        listForTestingReader.add("Book \"Three Comrades\" 322 novel \"Erich Maria Remarque\"");
        listForTestingReader.add("Book \"Three Mushketeers\" 300 novel \"Alexandre Dumas\"");
        listForTestingReader.add("Newspaper \"Times\" 30 weekly");
        listForTestingReader.add("Newspaper \"The Guardian\" 20 monthly");
        listForTestingReader.add("Newspaper \"SomeName\" 40 wrongPeriodicity");
        listForTestingReader.add("Magazine \"Time\" 100 adults");
        listForTestingReader.add("Magazine \"Funny pictures\" 100 children");
        listForTestingReader.add("Magazine \"someName\" 20 wrongAgeCategory");
        listForTestingReader.add("Book \"Capitan's daughter\" 150 Historical \"Alexandre Pushkin\"");
        listForTestingReader.add("Book \"Статский советник\" 315 Detective \"Boris Akunin\"");
        listForTestingReader.add("Book \"The Count of Monte Cristo\" 560 Adventure \"Alexandre Dumas\"");
        listForTestingReader.add("wrongType \"some name\" 44 Adventure \"some author\"");
        listForTestingReader.add("Book \"some name\" wrongPages detective \"adadad\"");
        listForTestingReader.add("Book \"123\" 45 wrongGenre \"somename\"");


    }

    @Test
    public void readDataFromFile() throws Exception {
        List<String> actual = reader.readDataFromFile(FILE_NAME);
        assertEquals(listForTestingReader, actual);
    }

    @Test(expected = NoFileException.class)
    public void readNullTest() throws NoFileException {
        reader.readDataFromFile(NULL_STRING);
    }

    @Test(expected = NoFileException.class)
    public void readEmptyStringTest() throws NoFileException {
        reader.readDataFromFile(EMPTY_STRING);
    }

}