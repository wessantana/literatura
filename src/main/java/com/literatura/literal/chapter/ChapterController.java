package com.literatura.literal.chapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books/{bookId}/chapters")
public class ChapterController {

    @Autowired
    ChapterService chapterService;

    // Maybe I'll delete it later. It don't make sense here.
    @GetMapping
    public List<ChapterDTO> getAllChaptersByBookId(@PathVariable UUID bookId) {
        return chapterService.getAllChaptersByBookId(bookId);
    }

    @PostMapping
    public ResponseEntity<ChapterDTO> addChapterToBook(@PathVariable UUID bookId, @RequestBody ChapterModel chapterModel) {
        ChapterDTO chapterDTO = chapterService.addChapterToBook(bookId, chapterModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(chapterDTO);
    }
}
