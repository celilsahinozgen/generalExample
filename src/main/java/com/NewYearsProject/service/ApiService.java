package com.NewYearsProject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class ApiService {


    private final RestTemplate restTemplate;


    private final HttpHeaders httpHeaders;

    private static final String CHAHRACTER_API = "https://rickandmortyapi.com/api/character";

    public Character getAllCharacter() {

        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<Character> response = restTemplate.exchange(CHAHRACTER_API, HttpMethod.GET,
                entity, Character.class);

        return response.getBody();
    }
}