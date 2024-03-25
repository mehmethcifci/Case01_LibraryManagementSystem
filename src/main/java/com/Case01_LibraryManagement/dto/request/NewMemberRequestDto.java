package com.Case01_LibraryManagement.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewMemberRequestDto {

    private String name;
    private String surname;
}
