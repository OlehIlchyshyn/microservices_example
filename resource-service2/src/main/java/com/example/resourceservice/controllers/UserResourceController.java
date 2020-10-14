package com.example.resourceservice.controllers;

import com.example.resourceservice.FeignService.UserServiceFeign;
import com.example.resourceservice.dtos.UserDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResourceController {
    @Autowired
    private UserServiceFeign userServiceFeign;

    @PostMapping("/saveUpdate")
    public UserDetailsDTO saveUpdate(@RequestBody UserDetailsDTO inputUser) {
        return userServiceFeign.saveUpdate(inputUser);
    }

    @GetMapping("/getById/{id}")
    public UserDetailsDTO getUserById(@PathVariable Long id) {
        return userServiceFeign.getUserById(id);
    }

    @GetMapping("/getById/{name}")
    public List<UserDetailsDTO> getUserByName(@PathVariable String name) {
        return userServiceFeign.getUserByName(name);
    }
}
