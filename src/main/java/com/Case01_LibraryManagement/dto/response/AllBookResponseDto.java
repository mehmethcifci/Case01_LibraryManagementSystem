package com.Case01_LibraryManagement.dto.response;

import com.Case01_LibraryManagement.entity.enums.State;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllBookResponseDto {
    private Long oid;
    private String ISBN;
    private String title;
    private String author;
    private int publicationYear;
    private State state;
}
