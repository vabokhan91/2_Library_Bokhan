package com.vbokhan.library.parser;

import com.vbokhan.library.exception.MissingDataException;
import com.vbokhan.library.validator.IssueValidator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vbokh on 04.06.2017.
 */
public class Parser {
    private final static String REGEX_FOR_PARSING = "([^\"]\\S*|\".+?\")\\s*";

    public List<LinkedList<String>> parseData(List<String> unparsedData) throws MissingDataException {
        if (unparsedData == null || unparsedData.isEmpty()) {
            throw new MissingDataException("No data was received for parsing");
        }
        List<LinkedList<String>> dataForCreatingIssues = new ArrayList<>();
        for (String parsingString : unparsedData) {
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
