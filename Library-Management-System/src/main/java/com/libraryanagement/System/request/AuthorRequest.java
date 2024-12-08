package com.libraryanagement.System.request;

import jakarta.validation.constraints.Size;

import java.util.Date;

public class AuthorRequest {

    private int id;

    private String name;

    private Date birthDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
