package com.libraryanagement.System.response;

public class AuthorResponse {

    private int id;

    private String Message;

    public AuthorResponse(int id, String message) {
        this.id = id;
        Message = message;
    }

    public AuthorResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
