package com.vbokhan.library.validator;

import com.vbokhan.library.exception.MissingDataException;

import java.util.regex.Pattern;

/**
 * Created by vbokh on 04.06.2017.
 */
public class IssueValidator {

    private final static String REGEX_FOR_BOOK = "\\s*(\\w+)\\s+\".+\"\\s+\\d+\\s+(\\w+)\\s\".+\"\\s*";
    private final static String REGEX_FOR_NEWSPAPER = "\\s*(\\w+)\\s+(\\\".+\\\")\\s+\\d+\\s+(daily||weekly||monthly)\\s*";
    private final static String REGEX_FOR_MAGAZINE = "\\s*(\\w+)\\s+(\\\".+\\\")\\s+\\d+\\s+(children||adults)\\s*";

    public static boolean validateData(String unvalidatedData) throws MissingDataException{
        if (unvalidatedData == null || unvalidatedData.isEmpty()) {
            throw new MissingDataException("No data was received to validate");
        }
        Pattern patternForBooks = Pattern.compile(REGEX_FOR_BOOK);
        Pattern patternForNewspaper = Pattern.compile(REGEX_FOR_NEWSPAPER);
        Pattern patternForMagazine = Pattern.compile(REGEX_FOR_MAGAZINE);
            if (patternForBooks.matcher(unvalidatedData).matches()) {
                return true;
            }
            if (patternForNewspaper.matcher(unvalidatedData).matches()) {
                return true;
            }
            if (patternForMagazine.matcher(unvalidatedData).matches()) {
                return true;
            }
        return false;
    }
}
