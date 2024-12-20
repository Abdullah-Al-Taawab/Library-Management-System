package com.libraryanagement.System.controller;

import com.libraryanagement.System.entity.Author;
import com.libraryanagement.System.entity.Book;
import com.libraryanagement.System.exception.BookApiException;
import com.libraryanagement.System.request.BookRequest;
import com.libraryanagement.System.response.BookResponse;
import com.libraryanagement.System.service.AuthorServiceImpl;
import com.libraryanagement.System.service.BookServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookManagementEndpoint {

    private BookServiceImpl bookServiceImpl;
    private AuthorServiceImpl authorService;

    @Autowired
    public BookManagementEndpoint(BookServiceImpl bookServiceImpl)

    {
        this.bookServiceImpl=bookServiceImpl;
    }

    @GetMapping({"/list", "/list/{title}"})
    public ResponseEntity<?> books(@PathVariable(value = "title", required = false) String title) {
        try {
            if (title == null) {
                // Fetch the full list of books
                List<Book> books = bookServiceImpl.find();
                return ResponseEntity.ok(books); // Return list of books with status 200
            } else {
                // Fetch a book by title
                Book book = bookServiceImpl.findByTitle(title);
                return ResponseEntity.ok(book); // Return the found book with status 200
            }
        } catch (Exception e) {
            // Handle errors and throw a custom exception
            throw new BookApiException("No Book Data Found");
        }
    }

 /*   @GetMapping("/list/{id}")
    public Book book(@PathVariable int id) {
        try {
            Book em = bookServiceImpl.findByID(id);
            return em;
        } catch (Exception e) {
            throw new BookApiException(" Details of this book not found ");
        }
    }*/


    @PostMapping("/add")
    public ResponseEntity<BookResponse> add(@Valid @RequestBody BookRequest bookRequest) {

        try {

            if(!bookServiceImpl.findAuthorId(bookRequest.getAuthorId()))
            {
                throw new BookApiException(" Enter Valid AuthorID ");
            }

            BookResponse response = new BookResponse();

            Book book = new Book();


            book.setTitle(bookRequest.getTitle());
            book.setAuthorId(bookRequest.getAuthorId());
            book.setPublishDate(bookRequest.getPublishDate());

            Book booktemp = bookServiceImpl.save(book);
            response.setId(booktemp.getId());
            response.setMessage(" Successfull ");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new BookApiException(" Bad Request ");
        }


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BookResponse> deleteData(@PathVariable int id) {
        try {
            BookResponse response = new BookResponse();
            int temp = bookServiceImpl.delete(id);
            if (temp == 1) {
                response.setMessage("Successfully deleted the book : " + id);
                return ResponseEntity.ok(response);
            } else {
                response.setMessage(" Book with this ID : " + id + " not found.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

            }
        }catch (Exception e) {
            throw new BookApiException(" No Book Found with this ID ");
        }


    }


  /*  @GetMapping("/list/{title}")
    public Book book(@PathVariable String title) {
        try {
            Book em = bookServiceImpl.findByTitle(title);
            return em;
        } catch (Exception e) {
            throw new BookApiException(" Details of this book not found ");
        }
    }*/



  /*  @GetMapping({"/list", "/list/{title}"})
    public ResponseEntity<?> books(@PathVariable(value = "title", required = false) String title) {
        try {
            if (title == null) {
                // Fetch the full list of books
                List<Book> books = bookServiceImpl.find();
                return ResponseEntity.ok(books); // Return list of books with status 200
            } else {
                // Fetch a book by title
                Book book = bookServiceImpl.findByTitle(title);
                return ResponseEntity.ok(book); // Return the found book with status 200
            }
        } catch (Exception e) {
            // Handle errors and throw a custom exception
            throw new BookApiException("No Book Data Found");
        }
    }*/
}
