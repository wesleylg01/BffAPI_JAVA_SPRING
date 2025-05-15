package com.wgluciano.bffapi.dto;

import lombok.Data;

@Data
public class ExternalUserDTO {
    private Long id;
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
