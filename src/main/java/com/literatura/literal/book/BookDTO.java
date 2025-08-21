package com.literatura.literal.book;

import com.literatura.literal.chapter.ChapterDTO;

import java.util.List;

public class BookDTO {

    private String title;
    private String synopsis;
    private String imageUrl;
    private List<ChapterDTO> chapters;
    private List<String> tags;

    public BookDTO() {}

    public BookDTO(BookModel book){
        this.title = book.getTitle();
        this.synopsis = book.getSynopsis();
        this.imageUrl = book.getImageUrl();
        this.chapters = book.getChapters()
                .stream()
                .map(ChapterDTO::new)
                .toList();
        this.tags = book.getTags();
    }

    public String getTitle() {return title;}

    public String getSynopsis() {return synopsis;}

    public String getImageUrl() {return imageUrl;}

    public List<ChapterDTO> getChapters() {return chapters;}


    public List<String> getTags() {return tags;}

}

