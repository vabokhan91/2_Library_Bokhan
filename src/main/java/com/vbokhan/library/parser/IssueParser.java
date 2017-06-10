package com.vbokhan.library.parser;

import com.vbokhan.library.exception.WrongDataException;
import com.vbokhan.library.validator.IssueValidator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vbokh on 04.06.2017.
 */
public class IssueParser {
    private final static String REGEX_FOR_PARSING = "([^\"]\\S*|\".+?\")\\s*";
//need smth to do with unoarsed data field
    public List<LinkedList<String>> parseData(Optional<List<String>> unparsedData) throws WrongDataException {
        if (!unparsedData.isPresent()|| unparsedData.get().isEmpty()) {
            throw new WrongDataException("No data was received for parsing");
        }
        List<LinkedList<String>> dataForCreatingIssues = new ArrayList<>();
        for (String parsingString : unparsedData.get()) {
            LinkedList<String> parsedData = new LinkedList<>();
            if (IssueValidator.validateData(parsingString)) {
                Matcher matcherForParsing = Pattern.compile(REGEX_FOR_PARSING).matcher(parsingString);
                while (matcherForParsing.find()) {
                    parsedData.add(matcherForParsing.group(1).replace("\"",""));
                }
                dataForCreatingIssues.add(parsedData);
            }
        }
        return dataForCreatingIssues;
    }
}
