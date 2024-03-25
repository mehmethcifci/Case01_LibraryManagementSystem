package com.Case01_LibraryManagement.exception;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Component
public class ExceptionResponse {
    private int exceptionCode;
    private String customMessage;
    private String exceptionMessage;
    private int httpStatus;
}
