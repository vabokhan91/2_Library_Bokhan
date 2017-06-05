package com.vbokhan.library.service;

import com.vbokhan.library.entity.Book;
import com.vbokhan.library.enums.Genre;
import com.vbokhan.library.exception.MissingDataException;
import com.vbokhan.library.interfaces.Issue;

import java.util.List;
import java.util.Optional;

/**
 * Created by vbokh on 04.06.2017.
 */
public class Calculator {
    public static Integer calculatePagesByGenre(List<Issue> issues, Genre genre) throws MissingDataException{
        if (issues == null || genre == null || issues.isEmpty()) {
            throw new MissingDataException("No data was received for calculating number of pages");
        }
        Integer result = 0;
        for (Issue issue : issues) {
            if (issue instanceof Book) {
                Book book = (Book) issue;
                if (book.getGenre().equals(genre)) {
                    result += book.getNumberOfPages();
                }
            }
        }
        return result;
    }
}
