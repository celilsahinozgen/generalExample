package com.NewYearsProject.service;

import com.NewYearsProject.Model.User;
import com.NewYearsProject.dto.UserCreateDto;
import com.NewYearsProject.dto.UserResponseDto;
import com.NewYearsProject.dto.UserUpdateDto;
import com.NewYearsProject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    public UserCreateDto createUser(UserCreateDto newUserDto) {

        User user= modelMapper.map(newUserDto, User.class);
        return modelMapper.map(userRepository.save(user), UserCreateDto.class);

    }
    public UserUpdateDto updateUser(UserUpdateDto userUpdateDto,Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            optionalUser.get().setMail(userUpdateDto.getMail());
            optionalUser.get().setPhoneNumber(userUpdateDto.getPhoneNumber());
            return modelMapper.map(userRepository.save(optionalUser.get()), UserUpdateDto.class);

        }
        throw new RuntimeException("kullanıcıbulunamadı");

    }

    public UserResponseDto findOneUser(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return modelMapper.map(optionalUser.get(), UserResponseDto.class);
        }
        throw new RuntimeException("kullanıcıbulunamadı");
    }


    public List<UserResponseDto> findAllUser() {
        List<User> listUser = userRepository.findAll();
        List<UserResponseDto> dtoUser = listUser.stream().map(user -> modelMapper.map(user, UserResponseDto.class)).collect(Collectors.toList());
        return dtoUser;
    }

    public Boolean deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
             userRepository.deleteById(id);
             return true;
        }
        throw new RuntimeException(" silinemedi");
    }
}
