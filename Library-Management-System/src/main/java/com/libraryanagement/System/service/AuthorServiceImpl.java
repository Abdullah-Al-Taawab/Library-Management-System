package com.libraryanagement.System.service;


import com.libraryanagement.System.dao.AuthorDaoImp;
import com.libraryanagement.System.entity.Author;
import com.libraryanagement.System.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorServiceImpl {

  private AuthorDaoImp authorDaoImp;


    public AuthorServiceImpl(AuthorDaoImp authorDaoImp) {
        this.authorDaoImp = authorDaoImp;
    }

    public Author findByID(int id)
    {
        return authorDaoImp.findByID(id);
    }

    public List<Author> find()
    {
        return authorDaoImp.findall();
    }

    @Transactional
    public Author save(Author  author)

    {
        Author authortemp=authorDaoImp.save(author);
        return authortemp;
    }

}
