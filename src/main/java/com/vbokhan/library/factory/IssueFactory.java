package com.vbokhan.library.factory;

import com.vbokhan.library.entity.*;
import com.vbokhan.library.enums.AgeCategory;
import com.vbokhan.library.enums.Genre;
import com.vbokhan.library.enums.Periodicity;
import com.vbokhan.library.exception.MissingDataException;
import com.vbokhan.library.interfaces.Issue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Created by vbokh on 04.06.2017.
 */
public class IssueFactory {
    public List<Issue> createIssue(List<LinkedList<String>> dataForCreatingIssue) throws MissingDataException{
        List<Issue> issues = new ArrayList<Issue>();
        if(dataForCreatingIssue)
        for (LinkedList<String> issueType : dataForCreatingIssue) {
            Optional.ofNullable(issueType).orElseThrow(() -> new MissingDataException("Type of issue can not be null"));
            TypeIssue type = TypeIssue.valueOf(issueType.pop().toUpperCase());
            switch (type) {
                case BOOK:
                    Book book = createBook(issueType);
                    issues.add(book);
                    break;
                case NEWSPAPER:
                    Newspaper newspaper = createNewspaper(issueType);
                    issues.add(newspaper);
                    break;
                case MAGAZINE:
                    Magazine magazine = createMagazine(issueType);
                    issues.add(magazine);
                    break;
            }
        }
        return issues;
    }

    private Magazine createMagazine(LinkedList<String> issueType) {
        String name = issueType.get(0);
        Integer numberOfPages = Integer.parseInt(issueType.get(1));
        AgeCategory ageCategory = AgeCategory.valueOf(issueType.get(2).toUpperCase());
        return new Magazine(name, numberOfPages, ageCategory);
    }

    private Newspaper createNewspaper(LinkedList<String> issueType) {
        String name = issueType.get(0);
        Integer numberOfPages = Integer.parseInt(issueType.get(1));
        Periodicity periodicity = Periodicity.valueOf(issueType.get(2).toUpperCase());
        return new Newspaper(name, numberOfPages, periodicity);
    }

    private Book createBook(LinkedList<String> dataForBook) {
        String name = dataForBook.get(0);
        Integer numberOfPages = Integer.valueOf(dataForBook.get(1));
        Genre genre = Genre.valueOf(dataForBook.get(2).toUpperCase());
        String author = dataForBook.get(3);
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
