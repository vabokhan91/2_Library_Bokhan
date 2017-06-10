package com.vbokhan.library.factory;

import com.vbokhan.library.entity.Issue;

import java.util.List;
import java.util.Map;

/**
 * Created by vbokh on 03.06.2017.
 */
public abstract class AbstractIssueFactory {
    public abstract List<Issue> createIssue(List<List<String>> dataForCreatingIssue);

}
