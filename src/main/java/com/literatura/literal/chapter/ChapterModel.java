package com.literatura.literal.chapter;

import com.literatura.literal.book.BookModel;
import jakarta.persistence.*;

import java.util.UUID;


@Entity
@Table(name = "chapter")
public class ChapterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookModel book;

    protected ChapterModel() {}

    public ChapterModel(String title, String content, BookModel book) {
        this.title = title;
        this.content = content;
        this.book = book;
    }

    public UUID getId() {return id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getContent() {return content;}

    public void setContent(String content) {this.content = content;}

    public BookModel getBook() {return book;}

    public void setBook(BookModel book) {this.book = book;}
}
