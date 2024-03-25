package com.Case01_LibraryManagement.exception;

import com.Case01_LibraryManagement.exception.custom.BookNotFoundException;
import com.Case01_LibraryManagement.exception.custom.LibraryNotFoundException;
import com.Case01_LibraryManagement.exception.custom.MemberNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    @ResponseBody
    @ExceptionHandler(LibraryNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleLibraryNotFoundException(LibraryNotFoundException exception){
        log.warn("Library is not found. {}",exception.getMessage());
        return createExceptionInfoResponse(ExceptionType.LIBRARY_NOT_FOUND);
    }
    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleMemberNotFoundException(MemberNotFoundException exception){
        log.warn("Member is not found. {}",exception.getMessage());
        return createExceptionInfoResponse(ExceptionType.MEMBER_NOT_FOUND);
    }
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleBookNotFoundException(BookNotFoundException exception){
        log.warn("Book is not found. {}",exception.getMessage());
        return createExceptionInfoResponse(ExceptionType.BOOK_NOT_FOUND);
    }
    private ResponseEntity<ExceptionResponse> createExceptionInfoResponse(ExceptionType exceptionType) {
        return new ResponseEntity<>(ExceptionResponse.builder()
                .exceptionCode(exceptionType.getCode())
                .customMessage(exceptionType.getMessage())
                .httpStatus(exceptionType.getHttpStatus().value())
                .build(), exceptionType.getHttpStatus());
    }
}
