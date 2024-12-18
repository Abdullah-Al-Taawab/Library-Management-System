package com.libraryanagement.System.dao;

import com.libraryanagement.System.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class BookDaoImp {

    private EntityManager entityManager;

    @Autowired
    public BookDaoImp(EntityManager entityManager)
    {
        this.entityManager=entityManager;
    }

    public List<Book> findall()
    {
        TypedQuery<Book> query= entityManager.createQuery("from Book", Book.class);

        List<Book> bookList=query.getResultList();

        return bookList;
    }

    public Book findByID(int Id)
    {
        Book em=entityManager.find(Book.class,Id);
        return em;
    }


    public Book findByTitle(String title) {


        Query query=entityManager.createQuery("FROM Book WHERE title = :title", Book.class);

        query.setParameter("title", title);

        Book book= (Book)query.getSingleResult();
            return book;
        }


    public boolean findAuthorId(int Id) {


        Query query=entityManager.createQuery("SELECT COUNT(a) FROM Author a WHERE a.id = :authorId");

        query.setParameter("authorId", Id);

        Long count = (Long) query.getSingleResult();

        return count > 0;

    }



    public Book save(Book book)
    {

        entityManager.persist(book);
        return book;

    }

    public int Delete(int id)

    {
        Query query=entityManager.createQuery("Delete from Book where id=:id");

        query.setParameter("id",id);

        int execute= query.executeUpdate();
        return execute;
    }






}
