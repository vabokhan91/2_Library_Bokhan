package com.vbokhan.library.factory;

import com.vbokhan.library.entity.Issue;
import com.vbokhan.library.exception.WrongDataException;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by vbokh on 03.06.2017.
 */
public abstract class AbstractIssueFactory {
    public abstract List<Issue> createIssues(List<LinkedList<String>> dataForCreatingIssue) throws WrongDataException;
}
