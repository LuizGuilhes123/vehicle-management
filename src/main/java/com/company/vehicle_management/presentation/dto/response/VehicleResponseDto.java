package com.company.vehicle_management.presentation.dto.response;

public record VehicleResponseDto(
        Long id,
        String brand,
        String model,
        Integer manufactureYear,
        Long clientId,
        String clientName
) {}
