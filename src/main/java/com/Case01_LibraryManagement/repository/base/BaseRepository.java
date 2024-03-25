package com.Case01_LibraryManagement.repository.base;

import com.Case01_LibraryManagement.entity.BaseClass.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository <T extends Book, Oid> extends JpaRepository<T, Oid> {
}
