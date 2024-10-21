package com.IJSE.POS_Spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.IJSE.POS_Spring.Entity.User;
import com.IJSE.POS_Spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    
     @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); //encode the password, so that it is not human readable

        return userRepository.save(user);
    }
}
