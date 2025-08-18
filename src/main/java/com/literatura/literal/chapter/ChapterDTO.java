package com.literatura.literal.chapter;

import com.literatura.literal.book.BookDTO;
import com.literatura.literal.book.BookModel;

public class ChapterDTO {

    private String title;
    private String content;
    private String bookTitle;

    protected ChapterDTO() {}

    public ChapterDTO(ChapterModel chapter, BookDTO book){
        this.title = chapter.getTitle();
        this.content = chapter.getContent();
        this.bookTitle = book.getTitle();
    }

    public String getTitle() {return title;}

    public String getContent() {return content;}

    public String getBookTitle() {return bookTitle;}

}
