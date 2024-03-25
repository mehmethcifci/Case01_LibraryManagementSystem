package com.Case01_LibraryManagement.service;

import com.Case01_LibraryManagement.dto.request.NewBookRequestDto;
import com.Case01_LibraryManagement.dto.request.UpdateBookRequestDto;
import com.Case01_LibraryManagement.dto.response.AllBookResponseDto;
import com.Case01_LibraryManagement.entity.BookScience;
import com.Case01_LibraryManagement.entity.Library;
import com.Case01_LibraryManagement.entity.enums.State;
import com.Case01_LibraryManagement.exception.custom.BookNotFoundException;
import com.Case01_LibraryManagement.repository.BookScienceRepository;
import com.Case01_LibraryManagement.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookScienceService {
    private final BookScienceRepository bookScienceRepository;
    private final LibraryRepository libraryRepository;

    public void save(NewBookRequestDto historyRequestDto) {
        Optional<Library> library = libraryRepository.findById(1L);
        if (library.isPresent()){
            BookScience bookScience = new BookScience();
            bookScience.setISBN(historyRequestDto.getISBN());
            bookScience.setAuthor(historyRequestDto.getAuthor());
            bookScience.setTitle(historyRequestDto.getTitle());
            bookScience.setLibrary(library.get());
            bookScience.setPublicationYear(historyRequestDto.getPublicationYear());
            bookScience.setState(State.CAN_BE_BORROWED);
            bookScienceRepository.save(bookScience);
        }
    }

    public List<AllBookResponseDto> findAll() {
        List<BookScience> bookScienceList = bookScienceRepository.findAll();
        if (bookScienceList.isEmpty()){
            throw new BookNotFoundException("Book is not found");
        }
        return bookScienceList.stream().map(historyBook -> AllBookResponseDto.builder()
                .author(historyBook.getAuthor())
                .ISBN(historyBook.getISBN())
                .title(historyBook.getTitle())
                .state(historyBook.getState())
                .publicationYear(historyBook.getPublicationYear())
                .build()).collect(Collectors.toList());
    }

    public void update(UpdateBookRequestDto updateDto) {
        if(bookScienceRepository.findById(updateDto.getOid()).isEmpty()){
            throw new BookNotFoundException("Book is not found");
        }
        BookScience bookScience = new BookScience();
        bookScience.setOid(updateDto.getOid());
        bookScience.setLibrary(libraryRepository.findById(1L).get());
        bookScience.setAuthor(updateDto.getAuthor());
        bookScience.setTitle(updateDto.getTitle());
        bookScience.setISBN(updateDto.getISBN());
        bookScience.setPublicationYear(updateDto.getPublicationYear());
        bookScience.setState(updateDto.getState());
        bookScienceRepository.save(bookScience);
    }

    public Boolean deleteCompany(Long id) {
        Optional<BookScience> optionalBook = bookScienceRepository.findById(id);
        if(optionalBook.isEmpty()){
            throw new BookNotFoundException("Book is not found");
        }
        bookScienceRepository.delete(optionalBook.get());
        return true;
    }
}

