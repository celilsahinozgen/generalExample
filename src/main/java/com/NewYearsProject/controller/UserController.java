package com.NewYearsProject.controller;


import com.NewYearsProject.dto.UserCreateDto;
import com.NewYearsProject.dto.UserResponseDto;
import com.NewYearsProject.dto.UserUpdateDto;

import com.NewYearsProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/save")
    public ResponseEntity<UserCreateDto> createUser(@RequestBody UserCreateDto newUserDto){
        UserCreateDto newuser = userService.createUser(newUserDto);
        return ResponseEntity.ok(newuser);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserUpdateDto> updateUser(@RequestBody UserUpdateDto userUpdateDto, @PathVariable Long id){
        UserUpdateDto editUser = userService.updateUser(userUpdateDto,id);
        return ResponseEntity.ok(editUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long id) {
        UserResponseDto getOneUser = userService.findOneUser(id);
        return ResponseEntity.ok(getOneUser);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserResponseDto>> findAll () {
        List<UserResponseDto> listUser = userService.findAllUser();
        return ResponseEntity.ok(listUser);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
        Boolean status = userService.deleteUser(id);
        return ResponseEntity.ok(status);
    }


}
