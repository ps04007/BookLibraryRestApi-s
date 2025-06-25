package com.library.book.library;

import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookLibraryService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks() {

        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    public Book createBook(Book book) {


        try{
            if(StringUtils.isEmpty(book.getIsbn())){
                throw new Exception("isbn is null");
            }
            return bookRepository.save(book);
        }catch (Exception e){
             Book book1=new Book();
             book1.setErrorResponse(e.getMessage());
             return book1;

        }



    }

    public Book updateBook(Long id, Book bookDetails) {
        if (id==null) throw new BookNotFoundException(id);
        Book book = getBookById(id);
        if (bookDetails != null) {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setIsbn(bookDetails.getIsbn());
        }
        return bookRepository.save(book);


    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}

//# BookLibraryRestApi Application
//
//        Spring Boot REST API application for managing books in a library.
//
//        Features: add,fetch,delete,fetch all books from library etc.
//
//        Tech Stack- Java17,SpringBoot,JPA,Maven,Mysql DB,Swagger etc.
//
//        instructions- checkout out project from github in your IDE like intellij, setup MySql Db(Oracle SQl developer) and provide db config in properties file,
//        compile and run application .once tomcate server started you can hit api's curl via postman and test.
//
//        Postman  collection are attaching for GET,POST,PUT,DELETE operations.



