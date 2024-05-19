package com.codesbybhuwan.restfulApi.controllers;

import com.codesbybhuwan.restfulApi.payloads.UserDto;
import com.codesbybhuwan.restfulApi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserCotroller {

//    Technique that a restapi must have
    @Autowired
    private UserService userService;
//    1. POST - create user
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){

        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

//    2. PUT - update user

//    3. DELETE - delete user

//    4. GET - find/get user


}
