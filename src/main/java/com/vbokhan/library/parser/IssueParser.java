package com.vbokhan.library.parser;

import com.vbokhan.library.exception.WrongDataException;
import com.vbokhan.library.validator.IssueValidator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vbokh on 04.06.2017.
 */
public class IssueParser {
    private static final String REGEX_FOR_PARSING = "([^\"]\\S*|\".+?\")\\s*";

    public List<LinkedList<String>> parseData(Optional<List<String>> unparsedData) throws WrongDataException {
        if (!unparsedData.isPresent() || unparsedData.get().isEmpty()) {
            throw new WrongDataException("No data was received for parsing");
        }
        List<LinkedList<String>> dataForCreatingIssues = new ArrayList<>();
        Pattern patternForParsing = Pattern.compile(REGEX_FOR_PARSING);
        for (String parsingString : unparsedData.get()) {
            LinkedList<String> parsedData = new LinkedList<>();
            if (IssueValidator.validateData(parsingString)) {
                Matcher matcherForParsing = patternForParsing.matcher(parsingString);
                while (matcherForParsing.find()) {
                    parsedData.add(matcherForParsing.group(1).replace("\"", ""));
                }
                dataForCreatingIssues.add(parsedData);
            }
        }
        return dataForCreatingIssues;
    }
}
