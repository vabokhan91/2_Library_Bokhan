package com.vbokhan.library.factory;

import com.vbokhan.library.entity.*;
import com.vbokhan.library.enums.AgeCategory;
import com.vbokhan.library.enums.Genre;
import com.vbokhan.library.enums.Periodicity;
import com.vbokhan.library.exception.IncorrectDataException;
import com.vbokhan.library.exception.MissingDataException;
import com.vbokhan.library.exception.WrongNumberOfValuesException;
import com.vbokhan.library.interfaces.Issue;
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

    public List<Issue> createIssue(List<LinkedList<String>> dataForCreatingIssue) throws MissingDataException{
        List<Issue> issues = new ArrayList<>();
        if (dataForCreatingIssue == null || dataForCreatingIssue.isEmpty()) {
            throw new MissingDataException("No data was received for creating issues");
        }
        for (LinkedList<String> issueValues : dataForCreatingIssue) {
            try {
                if (issueValues == null || issueValues.isEmpty()) {
                    throw new MissingDataException("No data was received for creating issue object");
                }
                String typeIssue = issueValues.pop().toUpperCase();
                TypeIssue issueType = TypeIssue.valueOf(typeIssue);
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
                        throw new IncorrectDataException(String.format("Unknown type of issue %s", issueType));
                }
            } catch (MissingDataException e) {
                LOGGER.log(Level.ERROR, e.getMessage());
            } catch (IncorrectDataException e) {
                LOGGER.log(Level.ERROR, e.getMessage());
            } catch (IllegalArgumentException e) {
                LOGGER.log(Level.ERROR, e.getMessage());
            } catch (WrongNumberOfValuesException e) {
                LOGGER.log(Level.ERROR, e.getMessage());
            }
        }
        return issues;
    }

    private Magazine createMagazine(LinkedList<String> issueValues) throws WrongNumberOfValuesException{
        if (issueValues.size() != 3) {
            throw new WrongNumberOfValuesException(String.format("Can not create object of Magazine. Wrong number of values %s. Need 3", issueValues.size()));
        }
        String name = issueValues.get(0);
        Integer numberOfPages = Integer.parseInt(issueValues.get(1));
        AgeCategory ageCategory = AgeCategory.valueOf(issueValues.get(2).toUpperCase());
        return new Magazine(name, numberOfPages, ageCategory);
    }

    private Newspaper createNewspaper(LinkedList<String> issueValues) throws WrongNumberOfValuesException{
        if (issueValues.size() != 3) {
            throw new WrongNumberOfValuesException(String.format("Can not create object of Newpaper. Wrong number of values %s. Need 3", issueValues.size()));
        }
        String name = issueValues.get(0);
        Integer numberOfPages = Integer.parseInt(issueValues.get(1));
        Periodicity periodicity = Periodicity.valueOf(issueValues.get(2).toUpperCase());
        return new Newspaper(name, numberOfPages, periodicity);
    }

    private Book createBook(LinkedList<String> issueValues) throws WrongNumberOfValuesException{
        if (issueValues.size() != 4) {
            throw new WrongNumberOfValuesException(String.format("Can not create object of book. Wrong number of values %s. Need 4", issueValues.size()));
        }
        String name = issueValues.get(0);
        Integer numberOfPages = Integer.valueOf(issueValues.get(1));
        Genre genre = Genre.valueOf(issueValues.get(2).toUpperCase());
        String author = issueValues.get(3);
        Book book = new Book(name, numberOfPages, genre, author);
        return book;
    }


    /*public static void main(String[] args) {
        Parser parser = new Parser();
        Reader reader = new Reader();
        IssueValidator validator = new IssueValidator();
        IssueFactory factory = new IssueFactory();
        try {
            List<String> strings = reader.readDataFromFile("src/main/resources/data.txt");
            List<String> validatedStrings = validator.validateData(strings);
            List<LinkedList<String >> res = parser.parseData(validatedStrings);
            List<Issue> result = factory.createIssue(res);

            System.out.println(result);
        } catch (NoFileException e) {
            e.printStackTrace();
        } catch (MissingDataException e) {
            e.printStackTrace();
        }
    }*/
}
