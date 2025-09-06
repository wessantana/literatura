package com.literatura.literal.chapter;

import com.literatura.literal.book.BookModel;
import com.literatura.literal.book.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChapterService {

    private final ChapterRepository chapterRepository;
    private final BookRepository bookRepository;

    @Autowired
    public ChapterService(ChapterRepository chapterRepository, BookRepository bookRepository) {
        this.chapterRepository = chapterRepository;
        this.bookRepository = bookRepository;
    }

    public List<ChapterDTO> getAllChaptersByBookId(UUID book_id) {
        return chapterRepository.getChaptersByBookId(book_id)
                .stream()
                .map(this::convertChapterModelToDTO).toList();
    }

    public ChapterDTO addChapterToBook(UUID bookId, ChapterModel chapterModel) {
        BookModel bookModel = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book not found."));
        chapterModel.setBook(bookModel);
        chapterRepository.save(chapterModel);
        return convertChapterModelToDTO(chapterModel);
    }

    public void deleteChapterByBookId(UUID bookId, UUID chapterId) {
        chapterRepository.deleteChapterByBookId(bookId, chapterId);
    }

    private ChapterDTO convertChapterModelToDTO(ChapterModel chapterModel) {
        return new ChapterDTO(chapterModel);
    }
}
