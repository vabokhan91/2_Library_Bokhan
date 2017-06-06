package com.vbokhan.library.generator;

/**
 * Created by vbokh on 31.05.2017.
 */
public class IdGenerator {
    private static int uniqueId = 0;

    public static int nextId() {
        return ++uniqueId;
    }
}
