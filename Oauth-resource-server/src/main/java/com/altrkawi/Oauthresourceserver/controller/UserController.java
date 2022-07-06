package com.altrkawi.Oauthresourceserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/api/users")
    public String[] getUsers(){
        return new String[]{"Mohammad", "Aicha", "Fares", "Julia"};
    }
}
