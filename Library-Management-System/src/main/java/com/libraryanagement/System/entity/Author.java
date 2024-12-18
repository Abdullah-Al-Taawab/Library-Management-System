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
@Table(name="author")
public class Author {

    @Id
    @Column(name="id")
    private int AuthorId;
    @Column(name="name")
    private String AuthorName;
    @Column(name="birth_date")
    private Date AuthorBirthDate;

    public Author() {
    }

    public Author(int authorId, Date authorBirthDate, String authorName) {
        AuthorId = authorId;
        AuthorBirthDate = authorBirthDate;
        AuthorName = authorName;
    }

    public int getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(int authorId) {
        AuthorId = authorId;
    }

    public Date getAuthorBirthDate() {
        return AuthorBirthDate;
    }

    public void setAuthorBirthDate(Date authorBirthDate) {
        AuthorBirthDate = authorBirthDate;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }
}
