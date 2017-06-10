package com.vbokhan.library.validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by vbokh on 05.06.2017.
 */
@RunWith(Parameterized.class)
public class IssueValidatorTest {
    private final String stringForTesting;
    private final boolean expected;

    public IssueValidatorTest(String stringForTesting, boolean expected) {
        this.stringForTesting = stringForTesting;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static List<Object[]> validatingData() {
        return Arrays.asList(new Object[][]{
                {"Book \"Three Comrades\" 322 novel \"Erich Maria Remarque\"", true},
                {"Book \"Three Mushketeers\" 300 novel \"Alexandre Dumas\"", true},
                {"Book \"Three. Musheketee.rs*\" 300 novel \"Alexandre Dumas\"", false},
                {"Newspaper \"Times\" 30 weekly", true},
                {"Newspaper \"SomeName\" 40 wrongPeriodicity", true},
                {"Magazine \"Funny pictures\" 100 children", true},
                {"Book \"some name\" wrongPages detective \"adadad\"",false}
        });
    }

    @Test
    public void validateData() throws Exception {
        boolean actual = IssueValidator.validateData(stringForTesting);
        assertEquals(expected, actual);
    }
}