package com.Case01_LibraryManagement.repository.base;

import com.Case01_LibraryManagement.entity.BaseClass.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {
    @Bean
    public BaseRepository<Book, Long> baseRepository() {
        return new BaseRepositoryImpl();
    }
}
