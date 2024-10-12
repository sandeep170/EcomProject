package com.samplespringbootcode.blog.controller;


import com.samplespringbootcode.blog.enitity.Post;
import com.samplespringbootcode.blog.payloads.APIResponse;
import com.samplespringbootcode.blog.payloads.PostDto;
import com.samplespringbootcode.blog.payloads.PostResponse;
import com.samplespringbootcode.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;
    //create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto postDto,
            @PathVariable("userId") Integer userId,
            @PathVariable("categoryId") Integer categoryId){

        PostDto createdPost = this.postService.createPost(postDto,userId,categoryId);
        return new ResponseEntity<PostDto>(createdPost, HttpStatus.CREATED);
    }

    //get by user
    @GetMapping("/user/{userID}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userID){
       List<PostDto> posts =  this.postService.getPostByUser(userID);
       return  new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }

    //get by Category
    @GetMapping("/category/{categoryID}/posts")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryID){
        List<PostDto> posts =  this.postService.getPostsByCategory(categoryID);
        return  new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }

/*    //get all post without sorting and pagination
    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPost(){
        List<PostDto> posts =  this.postService.getAllPost();
        return  new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }*/

    //get all post with pagination and sorting mechanism
    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPost(
            @RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize
    ){
        PostResponse postResponse =  this.postService.getAllPost(pageNumber,pageSize);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    //get all postById
    @GetMapping("/post/{postId}")
    public ResponseEntity<PostDto> getPostByPostId(@PathVariable Integer postId){
        PostDto post =  this.postService.getPostById(postId);
        return  new ResponseEntity<PostDto>(post, HttpStatus.OK);
    }
    //update posts
    @PutMapping("posts/update/{postId}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto,
                                                  @PathVariable Integer postId){

        PostDto updatedPostDto = this.postService.updatePost(postDto,postId);
        return new ResponseEntity<>(updatedPostDto,HttpStatus.OK);
    }

    //delete api
    @DeleteMapping("/posts/delete/{postID}")
    public APIResponse deletePost(@PathVariable Integer postID){
        this.postService.deletePost(postID);
        return new APIResponse("Post is successfuly deleted !!!", true);
    }
}
