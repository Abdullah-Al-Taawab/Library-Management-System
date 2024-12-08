package com.libraryanagement.System.dao;


import com.libraryanagement.System.entity.Author;
import com.libraryanagement.System.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDaoImp {

    private EntityManager entityManager;

    @Autowired
    public AuthorDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<Author> findall()
    {
        TypedQuery<Author> query= entityManager.createQuery("from Author", Author.class);

        List<Author> authorList=query.getResultList();

        return authorList;
    }

    public Author findByID(int Id)
    {
        Author em=entityManager.find(Author.class,Id);
        return em;
    }

    public Author save(Author author)
    {

        entityManager.persist(author);
        return author;

    }

}
