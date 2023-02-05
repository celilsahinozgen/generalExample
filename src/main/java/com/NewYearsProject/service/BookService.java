package com.NewYearsProject.service;


import com.NewYearsProject.Model.Book;
import com.NewYearsProject.dto.BookCreateDto;
import com.NewYearsProject.dto.BookResponseDto;
import com.NewYearsProject.dto.BookUpdateDto;
import com.NewYearsProject.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public BookCreateDto saveBook(BookCreateDto createDto) {
        Book book = modelMapper.map(createDto, Book.class);
        return modelMapper.map(bookRepository.save(book), BookCreateDto.class);
    }
    String ram;

    String hdd;

    int fiyat;

    public BookUpdateDto updateBook(Long id, BookUpdateDto bookUpdateDto) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            optionalBook.get().setFiyat(bookUpdateDto.getFiyat());
            optionalBook.get().setGuncellemetarihi(LocalDateTime.now());
            return modelMapper.map(bookRepository.save(optionalBook.get()), BookUpdateDto.class);
        }
        throw new RuntimeException("güncellenemedi");
    }

    public Iterable<BookResponseDto> findAllBook() {
        List<Book> listfindall = bookRepository.findAll();
        Iterable<BookResponseDto> findAllDto = listfindall.stream().map(book -> modelMapper.map(book, BookResponseDto.class)).collect(Collectors.toList());
        return findAllDto;
    }

    public List<BookResponseDto> findByIsım(String ismi) {
        List<Book> listBookName = bookRepository.findByIsmi(ismi);
        List<BookResponseDto> listDto = listBookName.stream().map(book -> modelMapper.map(book, BookResponseDto.class)).collect(Collectors.toList());
        return listDto;
    }

    public Iterable<BookResponseDto> findByYazari(String yazari) {
        List<Book> listBookYazar = bookRepository.findByYazari(yazari);
        Iterable<BookResponseDto> itirableBookYazar = listBookYazar.stream().map(book -> modelMapper.map(book, BookResponseDto.class)).collect(Collectors.toList());
        return itirableBookYazar;

    }

    public Iterable<BookResponseDto> findByYayinyili(String yayinyili) {
        List<Book> listBook = bookRepository.findByYayinyili(yayinyili);
        Iterable<BookResponseDto> itirableBookYayinyili = listBook.stream().map(book -> modelMapper.map(book, BookResponseDto.class)).collect(Collectors.toList());
        return itirableBookYayinyili;
    }

    public List<BookResponseDto> TariheGoreGetir(LocalDateTime startDate, LocalDateTime endDate) {
        List<Book> listuserdate = bookRepository.findAllByZamanGreaterThanEqualAndZamanLessThanEqual(startDate,endDate);
        List<BookResponseDto> listDateDto = listuserdate.stream().map(book -> modelMapper.map(book, BookResponseDto.class)).collect(Collectors.toList());
        return listDateDto;
    }
}
