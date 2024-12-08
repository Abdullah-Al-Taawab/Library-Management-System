package com.libraryanagement.System.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
public class Author {

    @Id
    private int Author_id;
    private String Author_name;
    private Date Author_birthDate;

    public Author(int Author_id, String Author_name, Date Author_birthDate) {
        this.Author_id = Author_id;
        this.Author_name = Author_name;
        this.Author_birthDate = Author_birthDate;
    }

    public Author() {
    }

    public int getAuthor_id() {
        return Author_id;
    }

    public void setAuthor_id(int author_id) {
        Author_id = author_id;
    }

    public String getAuthor_name() {
        return Author_name;
    }

    public void setAuthor_name(String author_name) {
        Author_name = author_name;
    }

    public Date getAuthor_birthDate() {
        return Author_birthDate;
    }

    public void setAuthor_birthDate(Date author_birthDate) {
        Author_birthDate = author_birthDate;
    }
}
