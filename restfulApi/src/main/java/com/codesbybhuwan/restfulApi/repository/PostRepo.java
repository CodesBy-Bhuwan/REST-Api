package com.codesbybhuwan.restfulApi.repository;

import com.codesbybhuwan.restfulApi.entities.Category;
import com.codesbybhuwan.restfulApi.entities.Post;
import com.codesbybhuwan.restfulApi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

//    Custome findBy using JPA
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

}
