package com.codesbybhuwan.restfulApi.controllers;

import com.codesbybhuwan.restfulApi.entities.Post;
import com.codesbybhuwan.restfulApi.payloads.ApiResponse;
import com.codesbybhuwan.restfulApi.payloads.PostDto;
import com.codesbybhuwan.restfulApi.payloads.PostResponse;
import com.codesbybhuwan.restfulApi.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
//    GetByUser
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByUser(
            @PathVariable Integer userId){

        List<PostDto> posts = this.postService.getPostByUser(userId);
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }
    //    GetByCategory
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByCategory(
            @PathVariable Integer categoryId){

        List<PostDto> posts = this.postService.getPostByCategory(categoryId);
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }
    //    Get All Post
    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPost(
            @RequestParam(value = "pageNumber", defaultValue = "0", required= false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize
    ){
        PostResponse postResponse = this.postService.getAllPost(pageNumber, pageSize);
        return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
    }
    //    Get post By Id
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(
            @PathVariable Integer postId
    ){
            PostDto postDto = this.postService.getPostById(postId);
            return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);
    }
    //delete Post
    @DeleteMapping("/posts/{postId}")
    public ApiResponse deletePost(
            @PathVariable Integer postId
    ){
        this.postService.deletePost(postId);
        return new ApiResponse("Post Successfully Deleted", true);
    }
    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(
            @RequestBody PostDto postDto,
            @PathVariable Integer postId
    ){
        PostDto updatePost = this.postService.updatePost(postDto, postId);
        return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);
    }
}
