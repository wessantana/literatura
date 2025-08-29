package com.literatura.literal.chapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ChapterRepository extends JpaRepository<ChapterModel, UUID> {

    @Query(value = "SELECT * FROM chapter WHERE book_id = :book_id LIMIT 10;", nativeQuery = true)
    public List<ChapterModel> getChaptersByBookId(@Param("book_id") UUID book_id);
}
