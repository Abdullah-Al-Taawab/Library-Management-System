package com.libraryanagement.System.exception;

public class BookApiException extends RuntimeException{

    public BookApiException() {
    }

    public BookApiException(String message) {
        super(message);
    }

    public BookApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookApiException(Throwable cause) {
        super(cause);
    }
}
