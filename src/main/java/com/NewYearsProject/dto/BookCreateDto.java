package com.NewYearsProject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

import static com.NewYearsProject.Model.Book.DATE_FORMAT;


@Data
public class BookCreateDto {


    String ismi;

    String yazari;

    String yayinyili;

    int sayfa;

    double fiyat;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    LocalDateTime guncellemetarihi;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    LocalDateTime zaman = LocalDateTime.now();
}
