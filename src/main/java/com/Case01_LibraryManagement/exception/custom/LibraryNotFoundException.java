package com.Case01_LibraryManagement.exception.custom;

public class LibraryNotFoundException extends RuntimeException{
    public LibraryNotFoundException(String message) {
        super(message);
    }
}