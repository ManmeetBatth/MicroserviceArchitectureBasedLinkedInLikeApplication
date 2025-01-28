package com.Projects.LinkedIn.user_service.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Projects.LinkedIn.user_service.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
    
}
