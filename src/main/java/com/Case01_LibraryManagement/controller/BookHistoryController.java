package com.Case01_LibraryManagement.controller;

import com.Case01_LibraryManagement.dto.request.NewBookRequestDto;
import com.Case01_LibraryManagement.dto.request.UpdateBookRequestDto;
import com.Case01_LibraryManagement.dto.response.AllBookResponseDto;
import com.Case01_LibraryManagement.service.BookHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bookhistory")
@RequiredArgsConstructor
public class BookHistoryController {
    private final BookHistoryService bookHistoryService;

    @PostMapping("/create")
    public ResponseEntity<Void> createBookHistory(@RequestBody @Valid NewBookRequestDto historyRequestDto) {
        bookHistoryService.save(historyRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/findall")
    public ResponseEntity<List<AllBookResponseDto>> findAllBook(){
        return ResponseEntity.ok(bookHistoryService.findAll());
    }
    @PutMapping("/update")
    public ResponseEntity<Void> updateBookHistory(@RequestBody @Valid UpdateBookRequestDto updateDto){
        bookHistoryService.update(updateDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Void> deleteBook(@PathVariable("id") Long id){
        bookHistoryService.deleteCompany(id);
        return ResponseEntity.ok().build();
    }
}
