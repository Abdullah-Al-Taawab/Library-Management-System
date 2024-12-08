package com.libraryanagement.System.controller;


import com.libraryanagement.System.entity.Author;
import com.libraryanagement.System.entity.Book;
import com.libraryanagement.System.exception.AuthorApiException;
import com.libraryanagement.System.exception.BookApiException;
import com.libraryanagement.System.request.AuthorRequest;
import com.libraryanagement.System.request.BookRequest;
import com.libraryanagement.System.response.AuthorResponse;
import com.libraryanagement.System.response.BookResponse;
import com.libraryanagement.System.service.AuthorServiceImpl;
import com.libraryanagement.System.service.BookServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorManagementEndpoint {

    private AuthorServiceImpl authorService;

    @Autowired
    public AuthorManagementEndpoint(AuthorServiceImpl authorService)

    {
        this.authorService=authorService;
    }


    @GetMapping("/list")
    public List<Author> authors() {
        try {
            List<Author> em = authorService.find();

            return authorService.find();
        } catch (Exception e) {
            throw new AuthorApiException(" No Author record found  ");
        }
    }

    @GetMapping("/list/{id}")
    public Author book(@PathVariable int id) {
        try {
            Author em = authorService.findByID(id);
            return em;
        } catch (Exception e) {
            throw new AuthorApiException(" No Author found with this Id ");
        }
    }

    @PostMapping("/add")
    public ResponseEntity<AuthorResponse> add(@Valid @RequestBody AuthorRequest authorRequest) {

        try {
            AuthorResponse response = new AuthorResponse();

            Author author = new Author();


            author.setAuthor_id(authorRequest.getId());

            author.setAuthor_name(authorRequest.getName());

            author.setAuthor_birthDate(authorRequest.getBirthDate());


            Author authorTemp = authorService.save(author);


            response.setId(authorTemp.getAuthor_id());
            response.setMessage(" Successfull ");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new AuthorApiException(" Bad Request ");
        }


    }
}
