package com.Case01_LibraryManagement.service;

import com.Case01_LibraryManagement.dto.request.NewMemberRequestDto;
import com.Case01_LibraryManagement.dto.request.UpdateMemberRequestDto;
import com.Case01_LibraryManagement.dto.response.AllMemberResponseDto;
import com.Case01_LibraryManagement.entity.Library;
import com.Case01_LibraryManagement.entity.Member;
import com.Case01_LibraryManagement.exception.custom.BookNotFoundException;
import com.Case01_LibraryManagement.exception.custom.MemberNotFoundException;
import com.Case01_LibraryManagement.repository.LibraryRepository;
import com.Case01_LibraryManagement.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final LibraryRepository libraryRepository;


    public void save(NewMemberRequestDto memberRequestDto) {
        Optional<Library> library = libraryRepository.findById(1L);
        if(library.isPresent()) {
            Member member = Member.builder()
                    .name(memberRequestDto.getName())
                    .surname(memberRequestDto.getSurname())
                    .library(library.get())
                    .build();
            memberRepository.save(member);
            library.get().getMemberList().add(member);
        }
    }

    public List<AllMemberResponseDto> findAll() {
        List<Member> memberList = memberRepository.findAll();
        if ((memberList.isEmpty())){
            throw new MemberNotFoundException("Member is not found");
        }
        return memberList.stream().map(member -> AllMemberResponseDto.builder()
                .oid(member.getOid())
                .name(member.getName())
                .surname(member.getSurname())
                .build()).collect(Collectors.toList());
    }

    public Boolean deleteMember(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        if (member.isEmpty()){
            throw new MemberNotFoundException("Member is not found");
        }
        memberRepository.delete(member.get());
        libraryRepository.findById(1L).get().getMemberList().remove(member);
        return true;
    }

    public void update(UpdateMemberRequestDto updateDto) {
        Optional<Member> memberOptional = memberRepository.findById(updateDto.getOid());
        if (memberOptional.isEmpty()){
            throw new MemberNotFoundException("Member is not found");
        }
        Member member = Member.builder()
                .oid(updateDto.getOid())
                .library(libraryRepository.findById(1L).get())
                .name(updateDto.getName())
                .surname(updateDto.getSurname())
                .build();
        memberRepository.save(member);
        Library library = libraryRepository.findById(1L).get();
        library.getMemberList().remove(memberOptional.get());
        library.getMemberList().add(member);
    }
}
