package com.literatura.literal.book;

import com.literatura.literal.chapter.ChapterDTO;
import com.literatura.literal.exceptions.BookNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void updateBookById(UUID id, UpdateBookRequestDTO bookRequest) {
        BookModel book = repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        if(bookRequest.getTitle() != null) {
            book.setTitle(bookRequest.getTitle());
        }

        if(bookRequest.getSynopsis() != null) {
            book.setSynopsis(bookRequest.getSynopsis());
        }

        if(bookRequest.getImageUrl() != null) {
            book.setImageUrl(bookRequest.getImageUrl());
        }

        if(bookRequest.getTags() != null) {
            book.getTags().clear();
            book.getTags().addAll(bookRequest.getTags());

        }

        repository.save(book);
    }

    private BookDTO convertBookModelToDTO(BookModel book) {
        return new BookDTO(book);
    }
}