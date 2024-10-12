package com.samplespringbootcode.blog.services;

import com.samplespringbootcode.blog.payloads.PostDto;
import com.samplespringbootcode.blog.payloads.PostResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    //create post

    PostDto createPost(com.samplespringbootcode.blog.payloads.PostDto postDto, Integer userId, Integer categoryId);
    //update post
    PostDto updatePost(com.samplespringbootcode.blog.payloads.PostDto postDto, Integer postId);
    //get all post without pagination
    List<PostDto> getAllPost();
    //get all post with pagination
    PostResponse getAllPost(Integer pageNumber, Integer pageSize);

    //get single post
    PostDto getPostById(Integer postId);
    //getPostByUserId
    List<PostDto> getPostByUser(Integer userId);
    //getAllPostByCategoryId
    List<PostDto> getPostsByCategory(Integer categoryId);

    //delete post
    void deletePost(Integer postId);

    //search Posts
    List<PostDto> searchPost(String keyword);
}
