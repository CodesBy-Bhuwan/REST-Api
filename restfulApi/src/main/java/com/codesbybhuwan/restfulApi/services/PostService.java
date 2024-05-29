package com.codesbybhuwan.restfulApi.services;

import com.codesbybhuwan.restfulApi.entities.Post;
import com.codesbybhuwan.restfulApi.payloads.PostDto;

import java.util.List;

public interface PostService {

//    Create
    PostDto createPost(PostDto postDto, Integer categoryId, Integer userId);
//    Here we take args for categoryId and userID

//    Update
    PostDto updatePost(PostDto postDto, Integer postId);

//    Delete
    void deletePost(Integer postId);

//    Get
    PostDto getPostById(Integer postId);

//    GetAll
    List<PostDto> getAllPost();

//    GetAll post by category
    List<PostDto> getPostByCategory(Integer categoryId);

//    GeAll post by user
    List<PostDto> getPostByUser(Integer userId);

//    SearchPost
    List<Post> searchPost(String keyword);

}
