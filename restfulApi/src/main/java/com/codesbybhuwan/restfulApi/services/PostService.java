package com.codesbybhuwan.restfulApi.services;

import com.codesbybhuwan.restfulApi.entities.Post;
import com.codesbybhuwan.restfulApi.payloads.PostDto;

import java.util.List;

public interface PostService {

//    Create
    PostDto createPost(PostDto postDto, Integer categoryId, Integer userId);
//    Here we take args for catagoryId and userID

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
