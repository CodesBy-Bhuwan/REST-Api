package com.codesbybhuwan.restfulApi.repository;

import com.codesbybhuwan.restfulApi.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {


}
