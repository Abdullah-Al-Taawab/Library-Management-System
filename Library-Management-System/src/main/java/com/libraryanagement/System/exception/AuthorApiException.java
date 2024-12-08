package com.libraryanagement.System.exception;

public class AuthorApiException extends RuntimeException{

    public AuthorApiException() {
    }

    public AuthorApiException(String message) {
        super(message);
    }

    public AuthorApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorApiException(Throwable cause) {
        super(cause);
    }
}
