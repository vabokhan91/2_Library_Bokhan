package com.vbokhan.library.validator;

import com.vbokhan.library.exception.WrongDataException;

import java.util.regex.Pattern;

/**
 * Created by vbokh on 04.06.2017.
 */
public class IssueValidator {
//think about one regexp for all
    private final static String REGEX_FOR_BOOK = "\\s*(\\w+)\\s+\"([\\w\\s\'а-яА-Я]+)\"\\s+\\d+\\s+(\\w+)\\s\"([\\w\\s\'а-яА-Я]+)\"\\s*";
    private final static String REGEX_FOR_NEWSPAPER = "\\s*(\\w+)\\s+(\"([\\w\\s\'а-яА-Я]+)\")\\s+\\d+\\s+([\\w\\s\'а-яА-Я]+)\\s*";
    private final static String REGEX_FOR_MAGAZINE = "\\s*(\\w+)\\s+(\"([\\w\\s\'а-яА-Я]+)\")\\s+\\d+\\s+([\\w\\s\'а-яА-Я]+)\\s*";

    public static boolean validateData(String unvalidatedData) throws WrongDataException {
        if (unvalidatedData == null || unvalidatedData.isEmpty()) {
            throw new WrongDataException("No data was received to validate");
        }
        boolean flag = false;
        Pattern patternForBooks = Pattern.compile(REGEX_FOR_BOOK);
        Pattern patternForNewspaper = Pattern.compile(REGEX_FOR_NEWSPAPER);
        Pattern patternForMagazine = Pattern.compile(REGEX_FOR_MAGAZINE);
            if (patternForBooks.matcher(unvalidatedData).matches()) {
                flag = true;
            }
            if (patternForNewspaper.matcher(unvalidatedData).matches()) {
                flag = true;
            }
            if (patternForMagazine.matcher(unvalidatedData).matches()) {
                flag = true;
            }
        return flag;
    }
}
