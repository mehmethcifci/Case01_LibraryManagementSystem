package com.Case01_LibraryManagement.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateLibraryRequestDto {
    private String libraryName;
}
