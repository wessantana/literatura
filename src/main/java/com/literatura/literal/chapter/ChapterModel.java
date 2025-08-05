package com.literatura.literal.chapter;

import com.literatura.literal.book.BookModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Entity
@Table(name = "chapter")
@NoArgsConstructor
@AllArgsConstructor
public class ChapterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookModel book;

}
