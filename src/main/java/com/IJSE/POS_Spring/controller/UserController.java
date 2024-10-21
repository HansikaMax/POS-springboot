package com.IJSE.POS_Spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.IJSE.POS_Spring.Entity.User;
import com.IJSE.POS_Spring.service.UserService;

@RestController
@CrossOrigin(origins="*")
public class UserController {
    
     @Autowired
    private UserService userService;

    @PostMapping("/auth/users")  //Sign-up
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
}
