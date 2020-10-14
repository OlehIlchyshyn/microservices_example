package com.example.resourceservice.controllers;

import com.example.resourceservice.dto.UserDetailsDTO;
import com.example.resourceservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/getById/{id}")
    public UserDetailsDTO getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping(value = "/getByName/{name}")
    public List<UserDetailsDTO> getUserByName(@PathVariable String name) {
        return userService.getByName(name);
    }

    @PostMapping(value = "/saveUpdate")
    public UserDetailsDTO saveUpdate(@RequestBody UserDetailsDTO inputUser) {
        return userService.saveUpdate(inputUser);
    }
}
