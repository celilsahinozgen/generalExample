package com.NewYearsProject.dto;


import lombok.Data;


@Data
public class ComputerCreateDto {

    Long id;


    String marka;

    String model;

    String ram;

    String ekrankarti;

    String islemci;

    String hdd;

    int fiyat;
}
