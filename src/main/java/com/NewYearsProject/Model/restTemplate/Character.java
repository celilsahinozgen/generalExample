package com.NewYearsProject.Model.restTemplate;

import lombok.Data;

import java.util.List;

@Data
public class Character {
    Info info;
    List<Result> results;
}
