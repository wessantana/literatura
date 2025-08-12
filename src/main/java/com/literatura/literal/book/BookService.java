package com.literatura.literal.book;

import com.literatura.literal.chapter.ChapterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<BookDTO> getAllBooks() {
        return repository.findAll().stream().map(this::convertBookModelToDTO).toList();
    }

    private BookDTO convertBookModelToDTO(BookModel book) {
        return new BookDTO(book);
    }
}