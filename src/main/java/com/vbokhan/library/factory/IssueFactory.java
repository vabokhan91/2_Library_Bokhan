package com.vbokhan.library.factory;

import com.vbokhan.library.entity.*;
import com.vbokhan.library.entity.AgeCategory;
import com.vbokhan.library.entity.Genre;
import com.vbokhan.library.entity.Periodicity;
import com.vbokhan.library.exception.WrongDataException;
import com.vbokhan.library.entity.Issue;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by vbokh on 04.06.2017.
 */
public class IssueFactory {
    private final static Logger LOGGER = LogManager.getLogger();

    public List<Issue> createIssues(List<LinkedList<String>> dataForCreatingIssue) throws WrongDataException {
        if (dataForCreatingIssue == null || dataForCreatingIssue.isEmpty()) {
            throw new WrongDataException("No data was received for creating issues");
        }
        ArrayList<Issue> issues = new ArrayList<>();
        for (LinkedList<String> issueValues : dataForCreatingIssue) {
            try {
                createIssue(issues, issueValues);
            } catch (WrongDataException e) {
                LOGGER.log(Level.ERROR, e.getMessage());
            } catch (IllegalArgumentException e) {
                LOGGER.log(Level.ERROR, e.getMessage());
            }
        }
        return issues;
    }

    private void createIssue(List<Issue> issues, LinkedList<String> issueValues) throws WrongDataException {
        if (issueValues == null || issueValues.isEmpty()) {
            throw new WrongDataException("No data was received for creating issue object");
        }
        TypeIssue issueType = TypeIssue.valueOf(issueValues.pop().toUpperCase());
        switch (issueType) {
            case BOOK:
                Book book = createBook(issueValues);
                issues.add(book);
                break;
            case NEWSPAPER:
                Newspaper newspaper = createNewspaper(issueValues);
                issues.add(newspaper);
                break;
            case MAGAZINE:
                Magazine magazine = createMagazine(issueValues);
                issues.add(magazine);
                break;
            default:
                throw new WrongDataException(String.format("Unknown type of issue %s", issueType));
        }
    }

    private Magazine createMagazine(LinkedList<String> issueValues) throws WrongDataException {
        if (issueValues.size() != 3) {
            throw new WrongDataException(String.format("Can not create object of Magazine. Wrong number of values %s. Need 3", issueValues.size()));
        }
        String title = issueValues.get(0);
        Integer numberOfPages = Integer.parseInt(issueValues.get(1));
        AgeCategory ageCategory = AgeCategory.valueOf(issueValues.get(2).toUpperCase());
        Magazine magazine = new Magazine(title, numberOfPages, ageCategory);
        LOGGER.log(Level.INFO, " New magazine is created " + magazine);
        return magazine;
    }

    private Newspaper createNewspaper(LinkedList<String> issueValues) throws WrongDataException {
        if (issueValues.size() != 3) {
            throw new WrongDataException(String.format("Can not create object of Newpaper. Wrong number of values %s. Need 3", issueValues.size()));
        }
        String title = issueValues.get(0);
        Integer numberOfPages = Integer.parseInt(issueValues.get(1));
        Periodicity periodicity = Periodicity.valueOf(issueValues.get(2).toUpperCase());
        Newspaper newspaper = new Newspaper(title, numberOfPages, periodicity);
        LOGGER.log(Level.INFO, " New newspaper is created :" + newspaper);
        return newspaper;
    }

    private Book createBook(LinkedList<String> issueValues) throws WrongDataException{
        if (issueValues.size() != 4) {
            throw new WrongDataException(String.format("Can not create object of book. Wrong number of values %s. Need 4", issueValues.size()));
        }
        String title = issueValues.get(0);
        Integer numberOfPages = Integer.valueOf(issueValues.get(1));
        Genre genre = Genre.valueOf(issueValues.get(2).toUpperCase());
        String author = issueValues.get(3);
        Book book = new Book(title, numberOfPages, genre, author);
        LOGGER.log(Level.INFO, "New book is created : " + book);
        return book;
    }
}
