package com.IJSE.POS_Spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.IJSE.POS_Spring.Entity.User;
import com.IJSE.POS_Spring.repository.UserRepository;
import com.IJSE.POS_Spring.security.JwtUtils;


@RestController
@CrossOrigin(origins="*")
public class AuthController {
    

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/auth/login")    //login
    public String login(@RequestBody User user){

        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwToken = jwtUtils.generateJwtToken(authentication);

        return jwToken;

    }

}
