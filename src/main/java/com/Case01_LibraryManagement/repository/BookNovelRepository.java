package com.Case01_LibraryManagement.repository;

import com.Case01_LibraryManagement.entity.BookNovel;
import com.Case01_LibraryManagement.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookNovelRepository extends BaseRepository<BookNovel, Long> {
}
