package com.Case01_LibraryManagement.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateMemberRequestDto {
    private Long oid;
    private String name;
    private String surname;
}
