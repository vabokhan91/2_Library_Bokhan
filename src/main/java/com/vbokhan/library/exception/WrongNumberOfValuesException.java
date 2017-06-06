package com.vbokhan.library.exception;

/**
 * Created by vbokh on 06.06.2017.
 */
public class WrongNumberOfValuesException extends Exception {
    public WrongNumberOfValuesException() {
    }

    public WrongNumberOfValuesException(String message) {
        super(message);
    }

    public WrongNumberOfValuesException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongNumberOfValuesException(Throwable cause) {
        super(cause);
    }
}
