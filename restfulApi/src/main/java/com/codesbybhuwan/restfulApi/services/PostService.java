package com.codesbybhuwan.restfulApi.services;

import com.codesbybhuwan.restfulApi.entities.Post;
import com.codesbybhuwan.restfulApi.payloads.PostDto;
import com.codesbybhuwan.restfulApi.payloads.PostResponse;

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
//    Now we will havt to list on pages so PostDto will be on PostResponse coz we need only few content in a page
    PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortByDir);

//    GetAll post by category
    List<PostDto> getPostByCategory(Integer categoryId);

//    GeAll post by user
    List<PostDto> getPostByUser(Integer userId);

//    SearchPost
    List<PostDto> searchPost(String keywords);

}
