package com.company.vehicle_management.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final PasswordEncoder encoder;

    public UserDetailsServiceImpl(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        if (!username.equals("admin")) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        String encodedPassword = encoder.encode("123");

        return User.builder()
                .username("admin")
                .password(encodedPassword)
                .roles("ADMIN")
                .build();
    }
}
