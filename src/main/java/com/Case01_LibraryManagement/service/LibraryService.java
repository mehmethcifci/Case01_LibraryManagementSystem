package com.Case01_LibraryManagement.service;

import com.Case01_LibraryManagement.dto.request.BorrowBookRequestDto;
import com.Case01_LibraryManagement.dto.request.CreateLibraryRequestDto;
import com.Case01_LibraryManagement.entity.*;
import com.Case01_LibraryManagement.entity.BaseClass.Book;
import com.Case01_LibraryManagement.entity.enums.State;
import com.Case01_LibraryManagement.exception.custom.BookNotFoundException;
import com.Case01_LibraryManagement.exception.custom.MemberNotFoundException;
import com.Case01_LibraryManagement.repository.*;
import com.Case01_LibraryManagement.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final MemberRepository memberRepository;
    @Qualifier("baseRepository")
    private final BaseRepository<Book, Long> baseRepository;;
    @Qualifier("bookHistoryRepository")
    private final BookHistoryRepository bookHistoryRepository;
    @Qualifier("bookNovelRepository")
    private final BookNovelRepository bookNovelRepository;
    @Qualifier("bookScienceRepository")
    private final BookScienceRepository bookScienceRepository;


    public void save(CreateLibraryRequestDto library) {
        libraryRepository.save(Library.builder()
                        .libraryName(library.getLibraryName())
                .build());
    }

    public void borrowBook(BorrowBookRequestDto borrowRequestDto) {
        Optional<Book> optionalBook = baseRepository.findById(borrowRequestDto.getBookOid());
        Optional<Member> optionalMember = memberRepository.findById(borrowRequestDto.getMemberOid());
        if (optionalBook.isEmpty()){
            throw new BookNotFoundException("Book is not found");
        }
        else if(optionalMember.isEmpty()){
            throw new MemberNotFoundException("Member is not found");
        }
        if (optionalBook.get() instanceof BookNovel){
            BookNovel bookNovel = (BookNovel) optionalBook.get();
            if (bookNovel.getState().equals(State.CAN_BE_BORROWED)){
                bookNovel.setState(State.ON_LOAN);
                bookNovelRepository.save(bookNovel);
            }

        }
        else if (optionalBook.get() instanceof BookScience){
            BookScience bookScience = (BookScience) optionalBook.get();
            if (bookScience.getState().equals(State.CAN_BE_BORROWED)){
                bookScience.setState(State.ON_LOAN);
                bookScienceRepository.save(bookScience);
            }
        }
        else if (optionalBook.get() instanceof BookHistory){
            BookHistory bookHistory = (BookHistory) optionalBook.get();
            if (bookHistory.getState().equals(State.CAN_BE_BORROWED)){
                bookHistory.setState(State.ON_LOAN);
                bookHistoryRepository.save(bookHistory);
            }
        }
        optionalMember.get().borrowBook(optionalBook.get());
    }

    public void returnBook(BorrowBookRequestDto returnBookRequestDto) {
        Optional<Book> optionalBook = baseRepository.findById(returnBookRequestDto.getBookOid());
        Optional<Member> optionalMember = memberRepository.findById(returnBookRequestDto.getMemberOid());
        if (optionalBook.isEmpty()){
            throw new BookNotFoundException("Book is not found");
        }
        else if(optionalMember.isEmpty()){
            throw new MemberNotFoundException("Member is not found");
        }
        if (optionalBook.get() instanceof BookNovel){
            BookNovel bookNovel = (BookNovel) optionalBook.get();
            bookNovel.setState(State.CAN_BE_BORROWED);
            bookNovelRepository.save(bookNovel);
        }
        else if (optionalBook.get() instanceof BookScience){
            BookScience bookScience = (BookScience) optionalBook.get();
            bookScience.setState(State.CAN_BE_BORROWED);
            bookScienceRepository.save(bookScience);
        }
        else if (optionalBook.get() instanceof BookHistory){
            BookHistory bookHistory = (BookHistory) optionalBook.get();
            bookHistory.setState(State.CAN_BE_BORROWED);
            bookHistoryRepository.save(bookHistory);
        }
        optionalMember.get().returnBook(optionalBook.get());
    }
}
