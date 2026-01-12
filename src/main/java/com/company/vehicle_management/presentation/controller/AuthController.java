package com.company.vehicle_management.presentation.controller;

import com.company.vehicle_management.presentation.dto.request.AuthRequestDto;
import com.company.vehicle_management.presentation.dto.response.AuthResponseDto;
import com.company.vehicle_management.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtService jwtService;

    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody AuthRequestDto request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        String token = jwtService.generateToken(request.username());
        return new AuthResponseDto(token);
    }
}
