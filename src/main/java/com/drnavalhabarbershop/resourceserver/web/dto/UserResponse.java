package com.drnavalhabarbershop.resourceserver.web.dto;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class UserResponse {

    private String email;
    private String password;
    private String roles;
}
