package com.library.book.library;

import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookLibraryService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks() {

        return bookRepository.findAll();
    }

    public ResponseEntity<Book> getBookById(Long id) {
        if (id == null) throw new BookNotFoundException(id);
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        return ResponseEntity.ok(book);

    }

    public ResponseEntity<Book> createBook(Book book) throws InvalidIsbnException {

        if (StringUtils.isEmpty(book.getIsbn())) {
            throw new InvalidIsbnException();
        }
        Book book1 = bookRepository.save(book);
        book1.setStatusCode("200");
        return new ResponseEntity<>(book1, HttpStatusCode.valueOf(200));

    }

    public ResponseEntity<Book> updateBook(Long id, Book bookDetails) throws InvalidIsbnException {
        if (id == null) throw new BookNotFoundException(id);
        Book book = getBookById(id).getBody();
        if (book == null) throw new BookNotFoundException(id);

        if (book.getIsbn() == null) throw new InvalidIsbnException();
        if (bookDetails != null) {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setIsbn(bookDetails.getIsbn());
        }

        Book book2 = bookRepository.save(book);
        book2.setStatusCode("200");

        return new ResponseEntity<>(book2, HttpStatusCode.valueOf(200));


    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}





