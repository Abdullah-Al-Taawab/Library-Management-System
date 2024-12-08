package com.libraryanagement.System.exception;

public class AuthorApiExcceptionResponse {

    private String Message;
    private int status;

    public AuthorApiExcceptionResponse() {
    }

    public AuthorApiExcceptionResponse(String message, int status) {
        Message = message;
        this.status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
