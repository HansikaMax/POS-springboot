package com.IJSE.POS_Spring.service;

import org.springframework.stereotype.Service;

import com.IJSE.POS_Spring.Entity.User;

@Service
public interface UserService {
    
    User createUser(User user);
}
