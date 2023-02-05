package com.NewYearsProject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

import static com.NewYearsProject.Model.Book.DATE_FORMAT;

@Data
public class BookUpdateDto {



    double fiyat;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    LocalDateTime guncellemetarihi;


}

