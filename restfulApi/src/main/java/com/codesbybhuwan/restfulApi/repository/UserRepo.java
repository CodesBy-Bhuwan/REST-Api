package com.codesbybhuwan.restfulApi.repository;



import com.codesbybhuwan.restfulApi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

}
