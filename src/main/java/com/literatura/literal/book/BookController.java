package com.literatura.literal.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService service;

    @GetMapping()
    public List<BookDTO> getAllBooks() {
        return service.getAllBooks();
    }

    @PostMapping(value = "/add")
    public void addBook(@RequestBody BookModel book) {
        service.addBook(book);
    }
}
