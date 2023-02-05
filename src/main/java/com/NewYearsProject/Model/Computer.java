package com.NewYearsProject.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "computer")
public class Computer {



    @Id
    Long id;

    @Field(type = FieldType.Text,name = "MARKA")
    String marka;
    @Field(type = FieldType.Text, name = "MODEL")
    String model;
    @Field(type = FieldType.Text,name = "RAM")
    String ram;
    @Field(type = FieldType.Text,name = "EKRANKARTI")
    String ekrankarti;
    @Field(type = FieldType.Text,name = "ISLEMCI")
    String islemci;
    @Field(type = FieldType.Text,name = "HDD")
    String hdd;
    @Field(type = FieldType.Integer,name = "FIYAT")
    int fiyat;

}
