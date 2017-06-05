package com.vbokhan.library.service;

import com.vbokhan.library.entity.Book;
import com.vbokhan.library.enums.Genre;
import com.vbokhan.library.exception.MissingDataException;
import com.vbokhan.library.exception.NoFileException;
import com.vbokhan.library.factory.IssueFactory;
import com.vbokhan.library.interfaces.Issue;
import com.vbokhan.library.parser.Parser;
import com.vbokhan.library.reader.Reader;
import com.vbokhan.library.validator.IssueValidator;

import java.util.*;

/**
 * Created by vbokh on 04.06.2017.
 */
public class Sorter {
    public static List<Issue> sortByNameASC(List<Issue> listForSorting) {
        listForSorting.sort((Issue a1, Issue a2)->a1.getName().compareTo(a2.getName()));
        return listForSorting;
    }

    public static List<Issue> sortByNameDESC(List<Issue> listForSorting) {
        listForSorting.sort((Issue a1, Issue a2)->a2.getName().compareTo(a1.getName()));
        return listForSorting;
    }

    public static List<Issue> sortByNumberOfPagesASC(List<Issue> listForSorting) {
        listForSorting.sort((Issue a1, Issue a2) -> a1.getNumberOfPages() - a2.getNumberOfPages());
        return listForSorting;
    }

    public static List<Issue> sortByNumberOfPagesDESC(List<Issue> listForSorting) {
        listForSorting.sort((Issue a1, Issue a2) -> a2.getNumberOfPages() - a1.getNumberOfPages());
        return listForSorting;
    }

    public static List<Issue> sortByNameAndPages(List<Issue> listForSorting) {
        listForSorting.sort((Comparator.comparing(Issue::getName).thenComparing(Issue::getNumberOfPages)));
        return listForSorting;
    }

    public static List<Book> sortBooksByGenre(List<Book> listForSorting) {
        listForSorting.sort((Book b1, Book b2) -> b1.getGenre().toString().compareTo(b2.getGenre().toString()));
        return listForSorting;
    }

    public static List<Issue> findByNumberOfPages(List<? extends Issue> issues, int from, int to) {
        List<Issue> foundIssues = new ArrayList<>();
        issues.stream().filter(issue -> issue.getNumberOfPages() >= from && issue.getNumberOfPages() <= to).forEach(foundIssues::add);
        return foundIssues;
    }

    public static List<Issue> findIssueByPreciseName(List<? extends Issue> issues, String name) {
        List<Issue> foundIssues = new ArrayList<>();
        issues.stream().filter(issue -> issue.getName().equalsIgnoreCase(name)).forEach(foundIssues::add);
        return foundIssues;
    }

    public static List<Issue> findIssueByPartialName(List<? extends Issue> issues, String partialName) {
        List<Issue> foundIssues = new ArrayList<>();
        issues.stream().filter(issue -> issue.getName().toLowerCase().contains(partialName.toLowerCase())).forEach(foundIssues::add);
        return foundIssues;
    }

    public static void main(String[] args) {
        Parser parser = new Parser();
        Reader reader = new Reader();
        IssueValidator validator = new IssueValidator();
        IssueFactory factory = new IssueFactory();
        try {
            List<String> strings = reader.readDataFromFile("src/main/resources/data.txt");
            List<LinkedList<String >> res = parser.parseData(strings);
            List<Issue> result = factory.createIssue(res);
            List<Book> books = new ArrayList<>();
            books.add(new Book("Raki1", 111, Genre.FICTION, "Besedka1"));
            books.add(new Book("Raki2", 212, Genre.FICTION, "Besedka2"));
            books.add(new Book("Raki3", 313, Genre.DETECTIVE, "Besedka3"));
            books.add(new Book("Raki4", 209, Genre.FICTION, "Besedka4"));
            books.add(new Book("Raki5", 2111, Genre.DETECTIVE, "Besedka5"));

            Sorter.sortByNameDESC(result);
           result.forEach(System.out::println);
            Sorter.sortByNumberOfPagesDESC(result);
//            result.forEach(System.out::println);
            Sorter.sortByNameAndPages(result);
//            result.forEach(System.out::println);
            Sorter.sortBooksByGenre(books);
//            books.forEach(System.out::println);
            List<Issue> test = Sorter.findByNumberOfPages(books, 200, 300);
//            test.forEach(System.out::println);
            List<Issue> testNames = Sorter.findIssueByPreciseName(result, "Tri bratishki");
//            testNames.forEach(System.out::println);

            List<Issue> testNames2 = Sorter.findIssueByPartialName(result, "tri");
//            testNames2.forEach(System.out::println);
        } catch (NoFileException e) {
            e.printStackTrace();
        } catch (MissingDataException e) {
            e.printStackTrace();
        }
    }
}
