package com.codesbybhuwan.restfulApi.payloads;
import com.codesbybhuwan.restfulApi.entities.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    private Integer postId;
    private String title;
    private String content;

//    We can assign in this technique too but the name will be changed once uploaded so better not assigning
//    private String imageName = "default.png";
//    Eventhough we won't pass tara we will have to return so se decalre reaming entities
    private String imageName;
    private Date addDate;
//    There is no post operation in CategoryDto and UserDto
    private CategoryDto category;
    private UserDto user;


//    Since we can make API for comment but here we will list those comments
    private Set<CommentDto> comments = new HashSet<>();
}
