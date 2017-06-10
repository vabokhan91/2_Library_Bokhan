package com.vbokhan.library.reader;

import com.vbokhan.library.exception.NoFileException;
import com.vbokhan.library.factory.IssueFactoryTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * Created by vbokh on 05.06.2017.
 */
public class IssueReaderTest {
    private static Optional<List<String>> listForTestingReader;
    private static IssueReader issueReader;
    private static final String FILE_NAME = IssueFactoryTest.class.getClassLoader().getResource("data/data.txt").getPath();
    private static final String EMPTY_STRING = "";
    private static final String NULL_STRING = null;

    @BeforeClass
    public static void init() {
        issueReader = new IssueReader();
        listForTestingReader = Optional.of(new ArrayList<>());
        listForTestingReader.get().add("Book \"Three Comrades\" 322 novel \"Erich Maria Remarque\"");
        listForTestingReader.get().add("Book \"Three Mushketeers\" 300 novel \"Alexandre Dumas\"");
        listForTestingReader.get().add("Book \"T/..hree Mush*keteers\" 300 novel \"Alexandre Dumas\"");
        listForTestingReader.get().add("Newspaper \"Times\" 30 weekly");
        listForTestingReader.get().add("Newspaper \"The Guardian\" 20 monthly");
        listForTestingReader.get().add("Newspaper \"SomeName\" 40 wrongPeriodicity");
        listForTestingReader.get().add("Magazine \"Time\" 100 adults");
        listForTestingReader.get().add("Magazine \"Funny pictures\" 100 children");
        listForTestingReader.get().add("Magazine \"someName\" 20 wrongAgeCategory");
        listForTestingReader.get().add("Book \"Capitan's daughter\" 150 Historical \"Alexandre Pushkin\"");
        listForTestingReader.get().add("Book \"Статский советник\" 315 Detective \"Boris Akunin\"");
        listForTestingReader.get().add("Book \"The Count of Monte Cristo\" 560 Adventure \"Alexandre Dumas\"");
        listForTestingReader.get().add("wrongType \"some name\" 44 Adventure \"some author\"");
        listForTestingReader.get().add("Book \"some name\" wrongPages detective \"adadad\"");
        listForTestingReader.get().add("Book \"123\" 45 wrongGenre \"somename\"");
    }

    @Test
    public void readDataFromFile() throws Exception {
        Optional<List<String>> actual = issueReader.readDataFromFile(FILE_NAME);
        assertEquals(listForTestingReader, actual);
    }

    @Test(expected = NoFileException.class)
    public void readNullTest() throws NoFileException {
        issueReader.readDataFromFile(NULL_STRING);
    }

    @Test(expected = NoFileException.class)
    public void readEmptyStringTest() throws NoFileException {
        issueReader.readDataFromFile(EMPTY_STRING);
    }

}