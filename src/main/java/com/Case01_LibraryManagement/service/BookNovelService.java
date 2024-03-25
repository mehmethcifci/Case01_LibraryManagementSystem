package com.Case01_LibraryManagement.service;

import com.Case01_LibraryManagement.dto.request.NewBookRequestDto;
import com.Case01_LibraryManagement.dto.request.UpdateBookRequestDto;
import com.Case01_LibraryManagement.dto.response.AllBookResponseDto;
import com.Case01_LibraryManagement.entity.BookNovel;
import com.Case01_LibraryManagement.entity.Library;
import com.Case01_LibraryManagement.entity.enums.State;
import com.Case01_LibraryManagement.exception.custom.BookNotFoundException;
import com.Case01_LibraryManagement.repository.BookNovelRepository;
import com.Case01_LibraryManagement.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookNovelService {
    private final BookNovelRepository bookNovelRepository;
    private final LibraryRepository libraryRepository;

    public void save(NewBookRequestDto historyRequestDto) {
        Optional<Library> library = libraryRepository.findById(1L);
        if (library.isPresent()){
            BookNovel bookNovel = new BookNovel();
            bookNovel.setISBN(historyRequestDto.getISBN());
            bookNovel.setAuthor(historyRequestDto.getAuthor());
            bookNovel.setTitle(historyRequestDto.getTitle());
            bookNovel.setLibrary(library.get());
            bookNovel.setPublicationYear(historyRequestDto.getPublicationYear());
            bookNovel.setState(State.CAN_BE_BORROWED);
            bookNovelRepository.save(bookNovel);
        }
    }

    public List<AllBookResponseDto> findAll() {
        List<BookNovel> bookNovelList = bookNovelRepository.findAll();
        if (bookNovelList.isEmpty()){
            throw new BookNotFoundException("Book is not found");
        }
        return bookNovelList.stream().map(historyBook -> AllBookResponseDto.builder()
                .author(historyBook.getAuthor())
                .ISBN(historyBook.getISBN())
                .title(historyBook.getTitle())
                .state(historyBook.getState())
                .publicationYear(historyBook.getPublicationYear())
                .build()).collect(Collectors.toList());
    }

    public void update(UpdateBookRequestDto updateDto) {
        if(bookNovelRepository.findById(updateDto.getOid()).isEmpty()){
            throw new BookNotFoundException("Book is not found");
        }
        BookNovel bookNovel = new BookNovel();
        bookNovel.setOid(updateDto.getOid());
        bookNovel.setLibrary(libraryRepository.findById(1L).get());
        bookNovel.setAuthor(updateDto.getAuthor());
        bookNovel.setTitle(updateDto.getTitle());
        bookNovel.setISBN(updateDto.getISBN());
        bookNovel.setPublicationYear(updateDto.getPublicationYear());
        bookNovel.setState(updateDto.getState());
        bookNovelRepository.save(bookNovel);
    }

    public Boolean deleteCompany(Long id) {
        Optional<BookNovel> optionalBook = bookNovelRepository.findById(id);
        if(optionalBook.isEmpty()){
            throw new BookNotFoundException("Book is not found");
        }
        bookNovelRepository.delete(optionalBook.get());
        return true;
    }
}
