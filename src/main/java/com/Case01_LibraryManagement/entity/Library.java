package com.Case01_LibraryManagement.entity;

import com.Case01_LibraryManagement.entity.BaseClass.Book;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "library")
@Builder
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;
    @Column(name = "library_name")
    private String libraryName;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> bookList;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Member> memberList;


}
