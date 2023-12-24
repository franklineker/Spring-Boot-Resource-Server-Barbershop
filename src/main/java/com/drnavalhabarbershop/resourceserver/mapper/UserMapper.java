package com.drnavalhabarbershop.resourceserver.mapper;

import com.drnavalhabarbershop.resourceserver.domain.Barber;
import com.drnavalhabarbershop.resourceserver.domain.User;
import com.drnavalhabarbershop.resourceserver.web.dto.UserRequest;
import com.drnavalhabarbershop.resourceserver.web.dto.UserResponse;
import lombok.NoArgsConstructor;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.time.LocalDateTime;

@NoArgsConstructor
public class UserMapper {

    private Barber barber;
    public static User toUser(UserRequest request) {
        return request != null ? User
                .builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .roles(request.getRoles())
                .build() : null;
    }

    public static User fromOauth2User(OAuth2User oAuth2User) {
        User user = User.builder()
                .createdDateTime(LocalDateTime.now())
                .email(oAuth2User.getAttributes().get("email").toString())
                .fullName(oAuth2User.getAttributes().get("name").toString())
                .firstName(oAuth2User.getAttributes().get("given_name").toString())
                .lastName(oAuth2User.getAttributes().get("family_name").toString())
                .pictureUrl(oAuth2User.getAttributes().get("picture").toString())
                .build();

        return user;
    }

    public static UserResponse toUserResponse(User user){
        return user != null ? UserResponse
                .builder()
                .email(user.getEmail())
                .roles(user.getRoles())
                .build() : null;
    }
}
