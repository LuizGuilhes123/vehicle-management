package com.company.vehicle_management.presentation.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VehicleRequestDto(

        @NotBlank(message = "Marca é obrigatória")
        String brand,

        @NotBlank(message = "Modelo é obrigatório")
        String model,

        @NotNull(message = "Ano de fabricação é obrigatório")
        @Min(value = 1900, message = "Ano inválido")
        @Max(value = 2100, message = "Ano inválido")
        Integer manufactureYear,

        @NotNull(message = "Cliente é obrigatório")
        Long clientId
) {}
