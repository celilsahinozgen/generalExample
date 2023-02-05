package com.NewYearsProject.service;


import com.NewYearsProject.Model.Computer;
import com.NewYearsProject.dto.ComputerCreateDto;
import com.NewYearsProject.dto.ComputerResponseDto;
import com.NewYearsProject.dto.ComputerUpdateDto;
import com.NewYearsProject.repository.ComputerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ComputerService {

    private final ComputerRepository computerRepository;
    private final ModelMapper modelMapper;

    public ComputerCreateDto create(ComputerCreateDto createDto) {
        Computer computer = modelMapper.map(createDto, Computer.class);
        return modelMapper.map(computerRepository.save(computer), ComputerCreateDto.class);
    }
    public ComputerUpdateDto updateComputer(Long id, ComputerUpdateDto computerUpdateDto) {
        Optional<Computer> optionalComputer = computerRepository.findById(id);
        if(optionalComputer.isPresent()){
            optionalComputer.get().setRam(computerUpdateDto.getRam());
            optionalComputer.get().setFiyat(computerUpdateDto.getFiyat());
            optionalComputer.get().setHdd(computerUpdateDto.getHdd());
            return modelMapper.map(computerRepository.save(optionalComputer.get()), ComputerUpdateDto.class);
        }
        throw new RuntimeException("Bilgisayar Güncellenemedi!!!");

    }


    public Boolean deleteComputer(Long id) {
        Optional<Computer> optionalComputer = computerRepository.findById(id);
        if (optionalComputer.isPresent()){
            computerRepository.deleteById(id);
            return true;
        }
        throw new RuntimeException("Bilgisayar Silinemedi!!!");
    }

    public Iterable<ComputerResponseDto> findByMarka(String marka) {
        List<Computer> computerMarkaList = computerRepository.findByMarka(marka);
        Iterable<ComputerResponseDto> computerDto = computerMarkaList.stream().map(computer -> modelMapper.map(computer, ComputerResponseDto.class)).collect(Collectors.toList());
        return computerDto;
    }

    public Iterable<ComputerResponseDto> findByModel(String model) {
        List<Computer> computerModelList = computerRepository.findByModel(model);
        Iterable<ComputerResponseDto> computerDto = computerModelList.stream().map(computer -> modelMapper.map(computer, ComputerResponseDto.class)).collect(Collectors.toList());
        return computerDto;
    }

    public List<ComputerResponseDto> findByFiyat(int startFiyat, int endFiyat) {
        List<Computer> listComputerFiyat = computerRepository.findAllByFiyatGreaterThanEqualAndFiyatLessThanEqual(startFiyat,endFiyat);
        List<ComputerResponseDto> computerDto = listComputerFiyat.stream().map(computer -> modelMapper.map(computer, ComputerResponseDto.class)).collect(Collectors.toList());
        return computerDto;

    }
}
