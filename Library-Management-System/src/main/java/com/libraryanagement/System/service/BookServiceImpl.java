package com.libraryanagement.System.service;

import com.libraryanagement.System.dao.BookDaoImp;
import com.libraryanagement.System.entity.Book;
import com.libraryanagement.System.request.BookRequest;
import com.libraryanagement.System.response.BookResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BookServiceImpl {

    private BookDaoImp bookDaoImp;

    @Autowired
    public BookServiceImpl(BookDaoImp bookDaoImp) {
        this.bookDaoImp = bookDaoImp;
    }


    public Book findByID(int id)
    {
        return bookDaoImp.findByID(id);
    }

    public List<Book> find()
    {
        return bookDaoImp.findall();
    }

    @Transactional
    public Book save(Book  book)

    {
        Book tempbook=bookDaoImp.save(book);
        return tempbook;
    }

    @Transactional
    public int delete(int id)
    {
        return bookDaoImp.Delete(id);
    }





}
