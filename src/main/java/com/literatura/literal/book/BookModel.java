package com.literatura.literal.book;

import com.literatura.literal.chapter.ChapterModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
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



}
