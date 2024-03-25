package com.Case01_LibraryManagement.exception.custom;

public class MemberNotFoundException extends RuntimeException{
    public MemberNotFoundException(String message) {
        super(message);
    }
}