package com.Case01_LibraryManagement.controller;

import com.Case01_LibraryManagement.dto.request.NewMemberRequestDto;
import com.Case01_LibraryManagement.dto.request.UpdateMemberRequestDto;
import com.Case01_LibraryManagement.dto.response.AllMemberResponseDto;
import com.Case01_LibraryManagement.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/create")
    public ResponseEntity<Void> createMember(@RequestBody @Valid NewMemberRequestDto memberRequestDto) {
        memberService.save(memberRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/findall")
    public ResponseEntity<List<AllMemberResponseDto>> findAllMember(){
        return ResponseEntity.ok(memberService.findAll());
    }
    @PutMapping("/update")
    public ResponseEntity<Void> updateMember(@RequestBody @Valid UpdateMemberRequestDto updateDto){
        memberService.update(updateDto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Void> deleteMember(@PathVariable("id") Long id){
        memberService.deleteMember(id);
        return ResponseEntity.ok().build();
    }
}
