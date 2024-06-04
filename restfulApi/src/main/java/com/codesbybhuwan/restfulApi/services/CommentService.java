package com.codesbybhuwan.restfulApi.services;

import com.codesbybhuwan.restfulApi.payloads.CommentDto;
import org.springframework.stereotype.Service;


public interface CommentService {

    CommentDto createComment(CommentDto commentDto, Integer postId );
    void deleteComment(Integer commentId);
}
