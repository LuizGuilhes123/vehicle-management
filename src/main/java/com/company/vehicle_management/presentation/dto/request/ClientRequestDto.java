package com.company.vehicle_management.presentation.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClientRequestDto(
        @NotBlank String name,
        @Email String email,
        @NotBlank String document
) {}
