package com.Case01_LibraryManagement.dto.request;

import com.Case01_LibraryManagement.entity.enums.State;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateBookRequestDto {
    private Long oid;
    private String ISBN;
    private String title;
    private String author;
    private int publicationYear;
    private State state;
}
