package com.example.bankservice.infrastructure.security;

import com.example.bankservice.application.port.out.PasswordHashserPort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class BCryptPasswordHasher implements PasswordHashserPort {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public String hash(String raw) {
        return encoder.encode(raw);
    }
}
