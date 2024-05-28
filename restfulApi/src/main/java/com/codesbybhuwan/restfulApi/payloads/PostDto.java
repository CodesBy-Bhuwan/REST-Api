package com.codesbybhuwan.restfulApi.payloads;

import com.codesbybhuwan.restfulApi.entities.Category;
import com.codesbybhuwan.restfulApi.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    private String title;
    private String content;

//    We can assign in this technique too but the name will be changed once uploaded so better not assigning
//    private String imageName = "default.png";
//    Eventhough we won't pass tara we will have to return so se decalre reaming entities
    private String imageName;
    private Date addDate;
    private Category category;
    private User user;
}
