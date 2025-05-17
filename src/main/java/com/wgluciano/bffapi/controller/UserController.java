package com.wgluciano.bffapi.controller;

import com.wgluciano.bffapi.dto.CreateUser;
import com.wgluciano.bffapi.dto.UserResponseDTO;
import com.wgluciano.bffapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @PostMapping
    public ResponseEntity<String> create (@RequestBody CreateUser createUser){
        UserResponseDTO response = userService.create(createUser);
        URI location = URI.create("/api/users/" + response.getId());

        return ResponseEntity
                .created(location)
                .build();
    }
}
