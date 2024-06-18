package com.codesbybhuwan.restfulApi.services;


import com.codesbybhuwan.restfulApi.entities.User;
import com.codesbybhuwan.restfulApi.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user, Integer userId);

    UserDto getUserById(Integer userId);

    List<UserDto> getAllUsers();

    void deleteUser(Integer userId);

//    # Create RegUsers
    UserDto registerNewUser(UserDto user);

}
