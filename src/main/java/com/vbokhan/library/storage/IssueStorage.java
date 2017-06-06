package com.vbokhan.library.storage;

import com.vbokhan.library.interfaces.Issue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vbokh on 04.06.2017.
 */

/* Do we need this class ???*/

public class IssueStorage {
    private List<Issue> issueStorage;
    private static IssueStorage instance;

    private IssueStorage() {
        if (instance != null) {
            throw new RuntimeException("Instance of class already exists");
        }
        issueStorage = new ArrayList<Issue>();
    }

    public static IssueStorage getInstance() {
        if (instance == null) {
            synchronized (IssueStorage.class) {
                if (instance == null) {
                    instance = new IssueStorage();
                }
            }
        }
        return instance;
    }

    public void updateStorage(List<Issue> newData) {
        issueStorage.addAll(newData);

    }

    public void updateStorage(Issue issue) {
        issueStorage.add(issue);
    }

    public List<Issue> getIssueStorage() {
        return issueStorage;
    }


}
