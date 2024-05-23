package com.codesbybhuwan.restfulApi.entities;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "post")

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(name = "post_title", nullable = false)
    private String title;

    @Column (length = 1000)
    private String content;
    private String imageName;
    private Date addDate;

//    Creating Relationships
//    In category if the is oneToMany then we need to annote with ManyToOne here
    @ManyToMany
//    We can also use JOIN
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToMany
    private User user;


}
