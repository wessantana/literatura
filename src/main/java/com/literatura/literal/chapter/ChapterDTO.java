package com.literatura.literal.chapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChapterDTO {

    private String title;
    private String content;
    private String bookTitle;

    private ChapterDTO(ChapterModel chapter){
        this.title = chapter.getTitle();
        this.content = chapter.getContent();
        this.bookTitle = chapter.getTitle();
    }
}
