package com.NewYearsProject.controller;

import com.NewYearsProject.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restTemplate")
public class ApiController {


    private final ApiService apiService;

    @GetMapping("/")
    public ResponseEntity<Character> getCharacters() {
        Character characters = apiService.getAllCharacter();
        return new ResponseEntity<>(characters, HttpStatus.OK);
    }
}
