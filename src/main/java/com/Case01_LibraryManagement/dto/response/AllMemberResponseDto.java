package com.Case01_LibraryManagement.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllMemberResponseDto {

    private long oid;
    private String name;
    private String surname;
}
