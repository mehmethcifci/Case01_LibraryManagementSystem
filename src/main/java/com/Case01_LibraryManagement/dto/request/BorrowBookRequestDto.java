package com.Case01_LibraryManagement.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BorrowBookRequestDto {
    private Long bookOid;
    private Long memberOid;
}
