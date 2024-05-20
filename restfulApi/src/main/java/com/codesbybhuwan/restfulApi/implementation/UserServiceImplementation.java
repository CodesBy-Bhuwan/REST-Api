package com.codesbybhuwan.restfulApi.implementation;

import com.codesbybhuwan.restfulApi.entities.User;
import com.codesbybhuwan.restfulApi.exceptions.ResourceNotFoundException;
import com.codesbybhuwan.restfulApi.payloads.UserDto;
import com.codesbybhuwan.restfulApi.repository.UserRepo;
import com.codesbybhuwan.restfulApi.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepo userRepo;


//    This ModelMapper is used to convert user into userDto automatically
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
//Here we will create User
        User user = this.dtoToUser(userDto);
//        here we have to convert UserDto to user
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
//        Here we will code to update user content
//        1.We get
        User user =this.userRepo.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User","id",userId));
//        2. We set
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
//        3. We updated
        User updateUser = this.userRepo.save(user);
//        4. Converted from Date Transfer object
        UserDto userDto1 = this.userToDto(updateUser);

        return userDto1;
    }

    @Override
    public UserDto getUserById(Integer userId) {

        User user=this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));

        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<User> users= this.userRepo.findAll();
        List<UserDto> userDtos= users.stream()
                .map(user -> this.userToDto(user))
                .collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {

        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user", "Id", userId));
        this.userRepo.delete(user);
    }
//This is manual technique
//    These methods will allow us to connect User with UserDto
//    This will convert userDto to USer obj
//    private User dtoToUser(UserDto userDto){
//
//        User user = new User();
//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setAbout(userDto.getAbout());
//        user.setPassword(userDto.getPassword());
//        return user;
//    }
////    This will convert user to userDto obj
//    public UserDto userToDto(User user){
//        UserDto userDto= new UserDto();
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setEmail(user.getEmail());
//        userDto.setAbout(user.getAbout());
//        userDto.setPassword(user.getPassword());
//        return userDto;
//    }

//    ####Alternative maethod is using ModelMapping technique
    private User dtoToUser(UserDto userDto){
        User user = this.modelMapper.map(userDto, User.class);
        return user;
    }
    private UserDto userToDto(User user){
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
