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
        this.chapters = book.getChapters().stream().map(ChapterDTO::new).toList();
        this.tags = book.getTags();
    }

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getSynopsis() {return synopsis;}

    public void setSynopsis (String synopsis) {this.synopsis = synopsis;}

    public String getImageUrl() {return imageUrl;}

    public void setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}

    public List<ChapterDTO> getChapters() {return chapters;}

    public void setChapters(List<ChapterDTO> chapters) {this.chapters = chapters;}

    public List<String> getTags() {return tags;}

    public void setTags(List<String> tags) {this.tags = tags;}
}

