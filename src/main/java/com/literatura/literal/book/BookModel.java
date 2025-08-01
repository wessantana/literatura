package com.literatura.literal.book;

import com.literatura.literal.chapter.ChapterModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable = false, length = 60)
    private String title;

    private String synopsis;

    private String imageUrl;

    @OneToMany(mappedBy = "books", cascade = CascadeType.ALL)
    private List<ChapterModel> chapters;

    private List<String> tags;



}
