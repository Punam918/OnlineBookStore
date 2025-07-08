package com.Ragnar.OnlineBookStore.controller;

import com.Ragnar.OnlineBookStore.dto.UserDTO;
import com.Ragnar.OnlineBookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Ragnar.OnlineBookStore.dto.LoginDTO;
import com.Ragnar.OnlineBookStore.filter.JwtAuthFilter;
import com.Ragnar.OnlineBookStore.service.JwtService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserDTO userDTO){
        return userService.registerUser(userDTO);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginDTO loginDTO) {
        return userService.loginUser(loginDTO);
    }


}
