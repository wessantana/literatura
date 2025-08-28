package com.literatura.literal.chapter;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChapterRepository extends JpaRepository<ChapterModel, UUID> {

}
