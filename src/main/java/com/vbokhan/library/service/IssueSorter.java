package com.vbokhan.library.service;

import com.vbokhan.library.entity.Book;
import com.vbokhan.library.entity.Issue;

import java.util.*;

/**
 * Created by vbokh on 04.06.2017.
 */
public class IssueSorter {
    public static List<Issue> sortByNameASC(List<Issue> listForSorting) {
        listForSorting.sort(Comparator.comparing(Issue::getTitle));
        return listForSorting;
    }

    public static List<Issue> sortByNameDESC(List<Issue> listForSorting) {
        listForSorting.sort((Issue a1, Issue a2)->a2.getTitle().compareTo(a1.getTitle()));
        return listForSorting;
    }

    public static List<Issue> sortByNumberOfPagesASC(List<Issue> listForSorting) {
        listForSorting.sort(Comparator.comparing(Issue::getNumberOfPages));
        return listForSorting;
    }

    public static List<Issue> sortByNumberOfPagesDESC(List<Issue> listForSorting) {
        listForSorting.sort((Issue a1, Issue a2) -> a2.getNumberOfPages() - a1.getNumberOfPages());
        return listForSorting;
    }

    public static List<Issue> sortByNameAndPages(List<Issue> listForSorting) {
        listForSorting.sort((Comparator.comparing(Issue::getTitle).thenComparing(Issue::getNumberOfPages)));
        return listForSorting;
    }

    public static List<Book> sortBooksByGenre(List<Book> listForSorting) {
        listForSorting.sort((Book b1, Book b2) -> b1.getGenre().toString().compareTo(b2.getGenre().toString()));
        return listForSorting;
    }



    /*public static void main(String[] args) {
        IssueParser parser = new IssueParser();
        IssueReader reader = new IssueReader();
        IssueValidator validator = new IssueValidator();
        IssueFactory factory = new IssueFactory();
        try {
            List<String> strings = reader.readDataFromFile("src/main/resources/data.txt");
            List<LinkedList<String >> res = parser.parseData(strings);
            List<Issue> result = factory.createIssues(res);
            List<Book> books = new ArrayList<>();
            books.add(new Book("Raki1", 111, Genre.NOVEL, "Besedka1"));
            books.add(new Book("Raki2", 212, Genre.HISTORICAL, "Besedka2"));
            books.add(new Book("Raki3", 313, Genre.DETECTIVE, "Besedka3"));
            books.add(new Book("Raki4", 209, Genre.ADVENTURE, "Besedka4"));
            books.add(new Book("Raki5", 2111, Genre.DETECTIVE, "Besedka5"));

            IssueSorter.sortByNameDESC(result);
           result.forEach(System.out::println);
            IssueSorter.sortByNumberOfPagesDESC(result);
//            result.forEach(System.out::println);
            IssueSorter.sortByNameAndPages(result);
//            result.forEach(System.out::println);
            IssueSorter.sortBooksByGenre(books);
//            books.forEach(System.out::println);
            List<Issue> test = IssueSorter.findByNumberOfPages(books, 200, 300);
//            test.forEach(System.out::println);
            List<Issue> testNames = IssueSorter.findIssueByPreciseName(result, "Tri bratishki");
//            testNames.forEach(System.out::println);

            List<Issue> testNames2 = IssueSorter.findIssueByPartialName(result, "tri");
//            testNames2.forEach(System.out::println);
        } catch (NoFileException e) {
            e.printStackTrace();
        } catch (MissingDataException e) {
            e.printStackTrace();
        }
    }*/
}
