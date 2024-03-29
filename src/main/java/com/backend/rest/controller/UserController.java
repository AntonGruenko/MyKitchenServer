package com.backend.rest.controller;

import com.backend.domain.User;
import com.backend.rest.dto.UserDto;
import com.backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping()
    public List<UserDto> getUser(){
        return userService.getAll().stream().map(UserDto::toDto).collect(Collectors.toList());
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, "application/x-www-form-urlencoded"})
    public UserDto insertUser( UserDto userDto){
        User user = userService.insert(UserDto.toDomainObject(userDto));
        return UserDto.toDto(user);

    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable int id) {

        return UserDto.toDto(userService.getById(id));
    }

    @GetMapping("/name/{name}")
    public List<UserDto> getUserByName(@PathVariable String name){

        return userService.findByName(name).stream().map(UserDto::toDto).collect(Collectors.toList());
    }

    @GetMapping("/email/{email}")
    public UserDto getByUserEmail(@PathVariable String email){

        return UserDto.toDto(userService.getByEmail(email));
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, "application/x-www-form-urlencoded"}, value = "/{id}")
    public UserDto updateUser(@PathVariable int id,
                              @RequestParam String name,
                              @RequestParam String email,
                              @RequestParam String password,
                              @RequestParam String status,
                              @RequestParam String profilePic,
                              @RequestParam int kcal,
                              @RequestParam int proteins,
                              @RequestParam int fats,
                              @RequestParam int carbohydrates,
                              @RequestParam long registrationDate){
        User user = userService.update(id, name, email, password, status, profilePic, kcal, proteins, fats, carbohydrates,registrationDate);
        return UserDto.toDto(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteById(id);
    }

}
