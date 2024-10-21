package com.IJSE.POS_Spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IJSE.POS_Spring.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    
    //to find user by username
    Optional<User> findByUsername(String username);
}
