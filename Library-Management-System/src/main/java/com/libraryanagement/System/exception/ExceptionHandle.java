package com.libraryanagement.System.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler
    public ResponseEntity<BookApiExceptionResponse> excep(BookApiException ex)
    {
        BookApiExceptionResponse e=new BookApiExceptionResponse();

        e.setMessage(ex.getMessage());
        e.setStatus(HttpStatus.NOT_IMPLEMENTED.value());

        return new ResponseEntity<>(e,HttpStatus.NOT_IMPLEMENTED);
    }

    @ExceptionHandler
    public ResponseEntity<AuthorApiExcceptionResponse> excep(AuthorApiException ex)
    {
        AuthorApiExcceptionResponse e=new AuthorApiExcceptionResponse();

        e.setMessage(ex.getMessage());
        e.setStatus(HttpStatus.NOT_IMPLEMENTED.value());

        return new ResponseEntity<>(e,HttpStatus.NOT_IMPLEMENTED);
    }
}
