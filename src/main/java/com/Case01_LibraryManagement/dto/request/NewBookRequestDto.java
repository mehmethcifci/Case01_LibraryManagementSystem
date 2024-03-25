package com.Case01_LibraryManagement.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewBookRequestDto {
    private String ISBN;
    private String title;
    private String author;
    private int publicationYear;

}
