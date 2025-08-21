package com.literatura.literal.book;

import com.literatura.literal.chapter.ChapterModel;
import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "book")
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 60)
    private String title;

    private String synopsis;

    private String imageUrl;


    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<ChapterModel> chapters;

    @ElementCollection
    private List<String> tags;

    protected BookModel(){}

    public BookModel(String title, String synopsis, String imageUrl, List<String> tags) {
        this.title = title;
        this.synopsis = synopsis;
        this.imageUrl = imageUrl;
        this.tags = tags;
    }

    public UUID getId(){return id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getSynopsis() {return synopsis;}

    public void setSynopsis (String synopsis) {this.synopsis = synopsis;}

    public String getImageUrl() {return imageUrl;}

    public void setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}

    public List<ChapterModel> getChapters() {return chapters;}

    public void setChapters(List<ChapterModel> chapters) {this.chapters = chapters;}

    public List<String> getTags() {return tags;}

    public void setTags(List<String> tags) {this.tags = tags;}
}
