package com.github.aksel.appSchool.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordHasher {

    private BCryptPasswordEncoder passwordEncoder;

    public String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
