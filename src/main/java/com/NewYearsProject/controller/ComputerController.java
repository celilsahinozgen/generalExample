package com.NewYearsProject.controller;


import com.NewYearsProject.dto.ComputerCreateDto;
import com.NewYearsProject.dto.ComputerResponseDto;
import com.NewYearsProject.dto.ComputerUpdateDto;
import com.NewYearsProject.service.ComputerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api1/computer")
@RestController
public class ComputerController {

    private final ComputerService computerService;

    @PostMapping("/save")
    public ResponseEntity<ComputerCreateDto> createComputer(@RequestBody ComputerCreateDto createDto){
        ComputerCreateDto createComputer = computerService.create(createDto);
        return ResponseEntity.ok(createComputer);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ComputerUpdateDto> updateComputer(@PathVariable Long  id,@RequestBody ComputerUpdateDto computerUpdateDto){
        ComputerUpdateDto updateComputer= computerService.updateComputer(id,computerUpdateDto);
        return ResponseEntity.ok(updateComputer);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteComputer (@PathVariable Long id){
        Boolean status = computerService.deleteComputer(id);
        return ResponseEntity.ok(status);
    }



    @GetMapping("/findByMarka/{marka}")
    public ResponseEntity<Iterable<ComputerResponseDto>> findByMarka (@PathVariable String marka){
        Iterable<ComputerResponseDto> iterableComputer = computerService.findByMarka(marka);
       return ResponseEntity.ok(iterableComputer);
    }

    @GetMapping("/findByMarka/{model}")
    public ResponseEntity<Iterable<ComputerResponseDto>> findByModel (@PathVariable String model){
        Iterable<ComputerResponseDto> iterableComputer = computerService.findByModel(model);
      return   ResponseEntity.ok(iterableComputer);
    }

    @GetMapping("/fiyat")
    public ResponseEntity<List<ComputerResponseDto>> findByMarka (@RequestParam("startFiyat")  int startFiyat,
                                                                    @RequestParam("endFiyat")  int endFiyat){
        List<ComputerResponseDto> ListFiyat = computerService.findByFiyat(startFiyat,endFiyat);
       return ResponseEntity.ok(ListFiyat);
    }




}
