package com.Case01_LibraryManagement.exception.custom;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message) {
        super(message);
    }
}