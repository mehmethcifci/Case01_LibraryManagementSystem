package com.Case01_LibraryManagement.entity;

import com.Case01_LibraryManagement.entity.BaseClass.Book;

public interface IMember{

    void borrowBook(Book book);
    void returnBook(Book book);

}
