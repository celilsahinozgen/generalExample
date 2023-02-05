package com.NewYearsProject.controller;


import com.NewYearsProject.dto.BookCreateDto;
import com.NewYearsProject.dto.BookResponseDto;
import com.NewYearsProject.dto.BookUpdateDto;
import com.NewYearsProject.dto.UserResponseDto;
import com.NewYearsProject.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api1/books")
public class BookController {

    private final BookService bookService;


    @PostMapping("/save")
    public ResponseEntity<BookCreateDto> createBook(@RequestBody BookCreateDto createDto){
        BookCreateDto newbook = bookService.saveBook(createDto);
        return ResponseEntity.ok(newbook);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BookUpdateDto> updateBook(@PathVariable Long id, @RequestBody BookUpdateDto bookUpdateDto){
        BookUpdateDto updateDto = bookService.updateBook(id,bookUpdateDto);
        return ResponseEntity.ok(updateDto);
    }

    @GetMapping("/findAll")
    public ResponseEntity<Iterable<BookResponseDto>> findAllBook() {
        Iterable<BookResponseDto> itirablebook = bookService.findAllBook();
        return ResponseEntity.ok(itirablebook);
    }

    @GetMapping("/findbyname/{ismi}")
    public ResponseEntity<List<BookResponseDto>> findByName(@PathVariable String ismi){
        List<BookResponseDto> listBookName = bookService.findByIsım(ismi);
        return ResponseEntity.ok(listBookName);
    }

    @GetMapping("/findbyname/{yazari}")
    public ResponseEntity<Iterable<BookResponseDto>> findByYazar(@PathVariable String yazari){
        Iterable<BookResponseDto> iterableYazar= bookService.findByYazari(yazari);
        return ResponseEntity.ok(iterableYazar);
    }


    @GetMapping("/findbyname/{yayinyili}")
    public ResponseEntity<Iterable<BookResponseDto>> findByYayinyili(@PathVariable String yayinyili) {
        Iterable<BookResponseDto> listYayinYili =bookService.findByYayinyili(yayinyili);
        return ResponseEntity.ok(listYayinYili);
    }

    @GetMapping("/findByTarih")
    public ResponseEntity<List<BookResponseDto>> findByTarih
            (@RequestParam("startDate")   @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime startDate,
             @RequestParam("endDate")   @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime endDate){
        List<BookResponseDto> listDate = bookService.TariheGoreGetir(startDate,endDate);
        return ResponseEntity.ok(listDate);
    }




}
