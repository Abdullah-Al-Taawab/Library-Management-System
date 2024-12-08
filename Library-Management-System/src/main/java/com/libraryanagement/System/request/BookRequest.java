package com.libraryanagement.System.request;



import jakarta.validation.constraints.Size;

import java.util.Date;

public class BookRequest {


    @Size(min=1, message = "Book name must have at least 1 characters")
    private String title;

    private int authorId;

    private Date publishDate;

    public @Size(min = 1, message = "Book name must have at least 1 characters") String getTitle() {
        return title;
    }

    public void setTitle(@Size(min = 1, message = "Book name must have at least 1 characters") String title) {
        this.title = title;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}
