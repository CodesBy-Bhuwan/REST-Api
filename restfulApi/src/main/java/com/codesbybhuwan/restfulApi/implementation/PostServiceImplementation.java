package com.codesbybhuwan.restfulApi.implementation;

import com.codesbybhuwan.restfulApi.entities.Post;
import com.codesbybhuwan.restfulApi.payloads.PostDto;
import com.codesbybhuwan.restfulApi.services.PostService;

import java.util.List;

public class PostServiceImplementation implements PostService {

    @Override
    public Post createPost(PostDto postDto) {
        return null;
    }

    @Override
    public Post updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public Post getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<Post> geAllPost() {
        return null;
    }

    @Override
    public List<Post> getPostByCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List<Post> getPostByUser(Integer userId) {
        return null;
    }

    @Override
    public List<Post> searchPost(String keyword) {
        return null;
    }
}
