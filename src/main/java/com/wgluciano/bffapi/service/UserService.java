package com.wgluciano.bffapi.service;

import com.wgluciano.bffapi.dto.ExternalUserDTO;
import com.wgluciano.bffapi.dto.UserResponseDTO;
import com.wgluciano.bffapi.integration.ExternalUserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final ExternalUserClient externalUserClient;

    public List<UserResponseDTO> getAllUsers() {
        List<ExternalUserDTO> externalUsers = externalUserClient.getUsers();

        return externalUsers.stream().map(user -> {
            UserResponseDTO dto = new UserResponseDTO();
            dto.setId(user.getId());
            dto.setNome(user.getName());
            dto.setEmail(user.getEmail());
            dto.setEndereco (user.getAddress().getCity() + " - " +user.getAddress().getStreet() + " "+user.getAddress().getSuite());
            return dto;
        }).collect(Collectors.toList());
    }

    public UserResponseDTO getUserById(long id){
        ExternalUserDTO user = externalUserClient.getUserById(id);

        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setNome(user.getName());
        dto.setEmail(user.getEmail());
        dto.setEndereco (user.getAddress().getCity() + " - " +user.getAddress().getStreet() + " "+user.getAddress().getSuite());
        return dto;
    }
}
