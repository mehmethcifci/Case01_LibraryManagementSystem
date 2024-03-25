package com.Case01_LibraryManagement.repository;

import com.Case01_LibraryManagement.entity.BookHistory;
import com.Case01_LibraryManagement.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookHistoryRepository extends BaseRepository<BookHistory, Long> {
}
