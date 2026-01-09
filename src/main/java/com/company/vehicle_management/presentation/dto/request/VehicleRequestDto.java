package com.company.vehicle_management.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VehicleRequestDto(
        @NotBlank String brand,
        @NotBlank String model,
        @NotNull Integer manufactureYear,
        @NotNull Long clientId
) {}
