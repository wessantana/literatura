package com.literatura.literal.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService service;

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping("/{id}")
    public Optional<BookDTO> getBookById(@PathVariable UUID id) {
        return service.getBookById(id);
    }

    @PostMapping
    public void addBook(@RequestBody BookModel book) {
        service.addBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable UUID id) {
        service.deleteBookById(id);
    }
}
