package com.wgluciano.bffapi.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateUser {
    private String name;
    private String email;
    private Address address;

    @Data
    public static class Address {
        private String suite;
        private String street;
        private String city;
    }
}
