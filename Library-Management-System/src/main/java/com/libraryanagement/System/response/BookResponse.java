package com.libraryanagement.System.response;

import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class BookResponse {

    private int id;

    private String Message;

    public BookResponse(int id, String message) {
        this.id = id;
        Message = message;
    }

    public BookResponse() {
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
