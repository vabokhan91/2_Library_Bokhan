package com.vbokhan.library.service;

import com.vbokhan.library.entity.Issue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vbokh on 06.06.2017.
 */
public class IssueFinder {
    public static List<Issue> findByNumberOfPages(List<? extends Issue> issues, int from, int to) {
        ArrayList<Issue> foundIssues = new ArrayList<>();
        issues.stream().filter(issue -> issue.getNumberOfPages() >= from && issue.getNumberOfPages() <= to).forEach(foundIssues::add);
        return foundIssues;
    }

    public static List<Issue> findIssueByPreciseName(List<? extends Issue> issues, String name) {
        ArrayList<Issue> foundIssues = new ArrayList<>();
        issues.stream().filter(issue -> issue.getTitle().equalsIgnoreCase(name)).forEach(foundIssues::add);
        return foundIssues;
    }

    public static List<Issue> findIssueByPartialName(List<? extends Issue> issues, String partialName) {
        ArrayList<Issue> foundIssues = new ArrayList<>();
        issues.stream().filter(issue -> issue.getTitle().toLowerCase().contains(partialName.toLowerCase())).forEach(foundIssues::add);
        return foundIssues;
    }
}
