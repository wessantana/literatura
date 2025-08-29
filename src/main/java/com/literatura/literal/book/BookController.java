package com.literatura.literal.book;

import com.literatura.literal.chapter.ChapterDTO;
import com.literatura.literal.chapter.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    ChapterService chapterService;

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Optional<BookDTO> getBookById(@PathVariable UUID id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/{id}/chapters")
    public List<ChapterDTO> getAllChaptersByBookId(@PathVariable UUID id) {
        return chapterService.getAllChaptersByBookId(id);
    }

    @PostMapping
    public void addBook(@RequestBody BookModel book) {
        bookService.addBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable UUID id) {
        bookService.deleteBookById(id);
    }
}
