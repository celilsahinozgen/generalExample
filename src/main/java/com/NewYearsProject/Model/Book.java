package com.NewYearsProject.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "bookss")
public class Book {

    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    @Id
    Long id;

    @Field(type = FieldType.Text,name = "ISIM")
    String ismi;
    @Field(type = FieldType.Text, name = "YAZARI")
    String yazari;
    @Field(type = FieldType.Text,name = "YAYINYILI")
    String yayinyili;
    @Field(type = FieldType.Integer,name = "SAYFA")
    int sayfa;
    @Field(type = FieldType.Double,name = "FIYAT")
    double fiyat;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = DATE_FORMAT, name = "GUNCELLEMETARİHİ")
    LocalDateTime guncellemetarihi;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = DATE_FORMAT, name = "KAYITTARİHİ")
    LocalDateTime zaman;

}
