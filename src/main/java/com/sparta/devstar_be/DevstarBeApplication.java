package com.sparta.devstar_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
        (exclude = SecurityAutoConfiguration.class) // Spring Security 인증 기능 제외
public class DevstarBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevstarBeApplication.class, args);
    }
}