package com.codesbybhuwan.restfulApi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "post")
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(name = "post_title", nullable = false)
    private String title;

    @Column (name= "content")
    private String content;
    private String imageName;
    private Date addDate;

//    Creating Relationships
//    In category if the is oneToMany then we need to annote with ManyToOne here
    @ManyToOne
//    We can also use JOIN
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();

}
