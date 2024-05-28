package com.codesbybhuwan.restfulApi.controllers;

import com.codesbybhuwan.restfulApi.payloads.PostDto;
import com.codesbybhuwan.restfulApi.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    private PostService postService;

//    Create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
//    PostMapping we haveto put userId&&categroyId and then we create post
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto postDto,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId){

        PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<>(createPost, HttpStatus.CREATED);

    }
}
