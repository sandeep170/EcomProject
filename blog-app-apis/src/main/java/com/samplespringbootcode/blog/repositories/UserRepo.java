package com.samplespringbootcode.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samplespringbootcode.blog.enitity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
  
}
