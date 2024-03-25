package com.Case01_LibraryManagement.entity;

import com.Case01_LibraryManagement.entity.BaseClass.Book;
import com.Case01_LibraryManagement.entity.enums.State;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "book_history")
@Builder
public class BookHistory extends Book {

    private State state;
}
