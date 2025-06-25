package com.library.book.library;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
@AllArgsConstructor
@NoArgsConstructor
public class BookLibraryController {

    @Autowired
    BookLibraryService bookLibraryService;

    @GetMapping("/books")
    public List<Book> getAllBooks() {

        return bookLibraryService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookLibraryService.getBookById(id);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) throws InvalidIsbnException {

        return bookLibraryService.createBook(book);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody Book book) throws Exception {
        return bookLibraryService.updateBook(id, book);
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable Long id) {
         bookLibraryService.deleteBookById(id);
         return ResponseEntity.ok("book deleted successfully").toString();

    }
}

