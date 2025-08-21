package com.literatura.literal.chapter;

import com.literatura.literal.book.BookDTO;
import com.literatura.literal.book.BookModel;

import java.util.UUID;

public class ChapterDTO {

    private String title;
    private String content;

    protected ChapterDTO() {}

    public ChapterDTO(ChapterModel chapter){
        this.title = chapter.getTitle();
        this.content = chapter.getContent();
    }

    public String getTitle() {return title;}

    public String getContent() {return content;}
}
