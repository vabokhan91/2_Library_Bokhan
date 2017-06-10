package com.vbokhan.library.service;

import com.vbokhan.library.entity.Book;
import com.vbokhan.library.entity.Genre;
import com.vbokhan.library.entity.Issue;
import com.vbokhan.library.exception.WrongDataException;

import java.util.List;

/**
 * Created by vbokh on 04.06.2017.
 */
public class IssueCalculator {
    public static Integer calculatePagesByGenre(List<Issue> issues, Genre genre) throws WrongDataException {
        if (issues == null || genre == null) {
            throw new WrongDataException("No data was received for calculating number of pages");
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
