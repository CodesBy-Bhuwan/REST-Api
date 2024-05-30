package com.codesbybhuwan.restfulApi.repository;

import com.codesbybhuwan.restfulApi.entities.Category;
import com.codesbybhuwan.restfulApi.entities.Post;
import com.codesbybhuwan.restfulApi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

//    Custome findBy using JPA
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
//////Technique 1 using method findByTitleContaining()
////  For Search Operation ->  List Post findBy-fieldName-must contain pass arg
//    List<Post> findByTitleContaining(String title);
////    It will generate similar like title query be generated

//    Technique 2 using query like %keyword%
    @Query("select p from Post p where p.title like :key")
    List<Post> searchPostByTitle(@Param("key") String title);


}
