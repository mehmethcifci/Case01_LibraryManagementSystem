package com.Case01_LibraryManagement.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ExceptionType {
    LIBRARY_NOT_FOUND(1001,"Library is not found",NOT_FOUND),
    MEMBER_NOT_FOUND(1002,"Member is not found",NOT_FOUND),
    BOOK_NOT_FOUND(1003,"Book is not found",NOT_FOUND);

    private int code;
    private String message;
    private HttpStatus httpStatus;
}
