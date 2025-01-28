package com.Projects.LinkedIn.posts_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Projects.LinkedIn.posts_service.entity.Post;

public interface PostsRepository extends JpaRepository<Post, Long> {

    List<Post> findByUserId(Long userId);

    
} 