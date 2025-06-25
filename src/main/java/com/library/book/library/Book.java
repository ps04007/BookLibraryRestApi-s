package com.library.book.library;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="BookLib")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    public String getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(String errorResponse) {
        this.errorResponse = errorResponse;
    }

    private String author;
    private String isbn;
    private Date publishedDate;

    private String errorResponse;

    public Book(String title, String author, String isbn, Date publishedDate) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishedDate = publishedDate;

    }

    public Book(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }
}
