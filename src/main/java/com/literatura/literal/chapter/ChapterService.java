package com.literatura.literal.chapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChapterService {

    @Autowired
    ChapterRepository repository;

    public List<ChapterDTO> getAllChaptersByBookId(UUID book_id) {
        return repository.getChaptersByBookId(book_id)
                .stream()
                .map(this::convertChapterModelToDTO).toList();
    }

    private ChapterDTO convertChapterModelToDTO(ChapterModel chapterModel) {
        return new ChapterDTO(chapterModel);
    }
}
