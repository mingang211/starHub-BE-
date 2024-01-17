package com.sparta.devstar_be.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginSuccessResponseDto {
    private Long userId;
    private String token;

    public LoginSuccessResponseDto(Long userId, String token) { // valueToken -> token
        this.userId = userId;
        this.token = "Bearer%20"+token;
    }
}