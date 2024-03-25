package com.Case01_LibraryManagement.entity;

import com.Case01_LibraryManagement.entity.BaseClass.Book;
import com.Case01_LibraryManagement.entity.enums.State;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "book_novel")
@Builder
public class BookNovel extends Book {
    @Enumerated(EnumType.STRING)
    private State state;
}
