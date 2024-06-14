package com.codesbybhuwan.restfulApi.security;

import com.codesbybhuwan.restfulApi.entities.User;
import com.codesbybhuwan.restfulApi.exceptions.ResourceNotFoundException;
import com.codesbybhuwan.restfulApi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        To load user form db by username
//        we take email as username
        User user =this.userRepo.findByEmail(username)
                .orElseThrow(()-> new ResourceNotFoundException("User", "email : "+ username, 0));

        return user;
    }
}
