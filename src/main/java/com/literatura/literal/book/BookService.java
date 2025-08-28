package com.literatura.literal.book;

import com.literatura.literal.chapter.ChapterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<BookDTO> getAllBooks() {
        return repository.findAll().stream().map(this::convertBookModelToDTO).toList();
    }

    public Optional<BookDTO> getBookById(UUID id) {
        return repository.findById(id).map(this::convertBookModelToDTO);
    }

    public void addBook(BookModel book) {
        repository.save(book);
    }

    // implementar retorno de status code correto e talvez algum content
    public void deleteBookById(UUID id) { repository.deleteById(id); }

    private BookDTO convertBookModelToDTO(BookModel book) {
        return new BookDTO(book);
    }
}