package com.wgluciano.bffapi.integration;

import com.wgluciano.bffapi.dto.CreateUser;
import com.wgluciano.bffapi.dto.ExternalUserDTO;
import com.wgluciano.bffapi.dto.UserResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "externalUserClient", url = "https://jsonplaceholder.typicode.com")
public interface ExternalUserClient {

    @GetMapping("/users")
    List<ExternalUserDTO> getUsers();

    @GetMapping("/users/{id}")
    ExternalUserDTO getUserById(@PathVariable long id);

    @PostMapping("/users")
    UserResponseDTO create(@RequestBody CreateUser request);
}

