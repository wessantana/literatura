package com.literatura.literal.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Optional<BookDTO> getBookById(@PathVariable UUID id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public void addBook(@RequestBody BookModel book) {
        bookService.addBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable UUID id) {
        bookService.deleteBookById(id);
    }

    @PatchMapping("/{id}")
    public void updateBookById(@PathVariable UUID id, @RequestBody UpdateBookRequestDTO bookRequest) {
        bookService.updateBookById(id, bookRequest);
    }
}
