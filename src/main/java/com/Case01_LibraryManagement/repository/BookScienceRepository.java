package com.Case01_LibraryManagement.repository;

import com.Case01_LibraryManagement.entity.BookScience;
import com.Case01_LibraryManagement.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookScienceRepository extends BaseRepository<BookScience, Long> {
}
