package com.vbokhan.library.interfaces;

import java.util.List;
import java.util.Map;

/**
 * Created by vbokh on 03.06.2017.
 */
public abstract class AbstractIssueFactory {
    public abstract List<Issue> createIssue(Map<String, List<String>> dataForCreatingIssue);

}
