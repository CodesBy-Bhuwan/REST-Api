package com.codesbybhuwan.restfulApi.controllers;

import com.codesbybhuwan.restfulApi.payloads.ApiResponse;
import com.codesbybhuwan.restfulApi.payloads.UserDto;
import com.codesbybhuwan.restfulApi.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserCotroller {

//    Technique that a restapi must have
    @Autowired
    private UserService userService;
//    1. POST - create user
    @PostMapping("/")
//    We are using @Valid annotation to enable HiberValidate so that enter value pass the condition
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){

        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }
//    2. PUT - update user
    @PutMapping("/{userId}")//this is also called path URI variable
//        If URI varaible and @Pathvar-Integer has same name then ue can use
//   ==>> public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto , @PathVariable("userId") Integer uId)
//    Else initialize varname in @PathVar so that new name can be set different

    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto , @PathVariable("userId") Integer uId){
        UserDto updatedUser = this.userService.updateUser(userDto, uId);
        return ResponseEntity.ok(updatedUser);
    }

//    3. DELETE - delete user
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
        this.userService.deleteUser(uid);
//        This technique when we don't want to use any ApiResponse
//        return new ResponseEntity(Map.of("messgae","User Deleted Successfully"), HttpStatus.OK);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully", true), HttpStatus.OK);
    }

//    4. GET - find/get user
//    4.1 Get Multiple Users
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){

        return ResponseEntity.ok(this.userService.getAllUsers());
    }

//    4.2 Get Single User only using userId
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }


}
