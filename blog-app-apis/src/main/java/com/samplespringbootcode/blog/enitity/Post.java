package com.samplespringbootcode.blog.enitity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    @Column(name = "post_title", length = 100, nullable = false)
    private String title;
    @Column(name = "post_content", length = 10000, nullable = false)
    private String content;
    @Column(name = "post_image_name")
    private String imageName;
    @Column(name = "post_added_date")
    private Date addedDate;

    //2 parent resource: category and user

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}
