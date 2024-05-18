package com.codesbybhuwan.restfulApi.services;


import com.codesbybhuwan.restfulApi.entities.User;
import com.codesbybhuwan.restfulApi.payloads.UserDto;

public interface UserService {

    UserDto createUser(UserDto user);
}
