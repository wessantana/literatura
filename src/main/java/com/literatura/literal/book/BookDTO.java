package com.literatura.literal.book;

import com.literatura.literal.chapter.ChapterDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private String title;
    private String synopsis;
    private String imageUrl;
    private List<ChapterDTO> chapters;
    private List<String> tags;

    public BookDTO(BookModel book){
        this.title = book.getTitle();
        this.synopsis = book.getSynopsis();
        this.imageUrl = book.getImageUrl();
        this.chapters = book.getChapters().stream().map(ChapterDTO::new).toList();
        this.tags = book.getTags();
    }
}
