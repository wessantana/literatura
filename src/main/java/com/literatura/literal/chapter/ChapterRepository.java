package com.literatura.literal.chapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface ChapterRepository extends JpaRepository<ChapterModel, UUID> {

    @Query(value = "SELECT * FROM chapter WHERE book_id = :book_id LIMIT 10;", nativeQuery = true)
    public List<ChapterModel> getChaptersByBookId(@Param("book_id") UUID book_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM chapter WHERE id = :chapterId AND book_id = :bookId;", nativeQuery = true)
    public void deleteChapterByBookId(@Param("bookId") UUID bookId, @Param("chapterId") UUID chapterId);

    @Modifying
    @Transactional
    @Query(value = """
            UPDATE chapter
            SET
                title = CASE WHEN :newTitle IS NOT NULL THEN :newTitle ELSE title END,
                content = CASE WHEN :newContent IS NOT NULL THEN :newContent ELSE content END
            WHERE id = :chapterId AND book_id = :bookId;
            """, nativeQuery = true)
    public void updateChapterByBookId(
            @Param("bookId") UUID bookId,
            @Param("chapterId") UUID chapterId,
            @Param("newTitle") String newTitle,
            @Param("newContent") String newContent);
}
