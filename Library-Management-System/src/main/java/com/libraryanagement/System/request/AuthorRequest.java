package com.libraryanagement.System.request;

import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Size;



import java.util.Date;

public class AuthorRequest {

    @NotNull
    private int authorId;
    @NotNull
    private String authorName;
    @NotNull
    private Date authorBirthDate;

    @NotNull
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(@NotNull int authorId) {
        this.authorId = authorId;
    }

    public @NotNull String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(@NotNull String authorName) {
        this.authorName = authorName;
    }

    public @NotNull Date getAuthorBirthDate() {
        return authorBirthDate;
    }

    public void setAuthorBirthDate(@NotNull Date authorBirthDate) {
        this.authorBirthDate = authorBirthDate;
    }
}
