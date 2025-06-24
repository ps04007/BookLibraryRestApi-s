package com.library.book.library;

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

        return bookRepository.save(book);
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

