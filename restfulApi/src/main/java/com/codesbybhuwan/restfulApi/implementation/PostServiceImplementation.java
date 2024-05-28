package com.codesbybhuwan.restfulApi.implementation;

import com.codesbybhuwan.restfulApi.entities.Category;
import com.codesbybhuwan.restfulApi.entities.Post;
import com.codesbybhuwan.restfulApi.entities.User;
import com.codesbybhuwan.restfulApi.exceptions.ResourceNotFoundException;
import com.codesbybhuwan.restfulApi.payloads.PostDto;
import com.codesbybhuwan.restfulApi.repository.CategoryRepo;
import com.codesbybhuwan.restfulApi.repository.PostRepo;
import com.codesbybhuwan.restfulApi.repository.UserRepo;
import com.codesbybhuwan.restfulApi.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class PostServiceImplementation implements PostService {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDto createPost(PostDto postDto, Integer categoryId, Integer userId ) {

        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User id", userId));

        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Category id", categoryId));


//        Using ModelMapper tech convert postDto into post
        Post post = this.modelMapper.map(postDto, Post.class);
//        Using this modelMapper only title and content will only be mapped but for entity we have to set manually
//        Which entities has to be set see form Post.
        post.setImageName("default.png");
        post.setAddDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post newPost = this.postRepo.save(post);

        return this.modelMapper.map(newPost, PostDto.class);
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
