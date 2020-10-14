package com.example.resourceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDetailsDTO {
    private String id;
    private String name;
    private String age;
}
