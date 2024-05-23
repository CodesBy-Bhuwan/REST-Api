package com.codesbybhuwan.restfulApi.services;

import com.codesbybhuwan.restfulApi.entities.Post;
import com.codesbybhuwan.restfulApi.payloads.PostDto;

import java.util.List;

public interface PostService {

//    Create
    Post createPost(PostDto postDto);

//    Update
    Post updatePost(PostDto postDto, Integer postId);

//    Delete
    void deletePost(Integer postId);

//    Get
    Post getPostById(Integer postId);

//    GetAll
    List<Post> geAllPost();

//    GetAll post by category
    List<Post> getPostByCategory(Integer categoryId);

//    GeAll post by user
    List<Post> getPostByUser(Integer userId);

//    SearchPost
    List<Post> searchPost(String keyword);

}