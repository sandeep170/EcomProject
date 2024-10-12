package com.samplespringbootcode.blog.repositories;

import com.samplespringbootcode.blog.enitity.Category;
import com.samplespringbootcode.blog.enitity.Post;
import com.samplespringbootcode.blog.enitity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);
}
