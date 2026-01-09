package com.company.vehicle_management.infrastructure.mapper;


import com.company.vehicle_management.domain.entity.VehicleEntity;
import com.company.vehicle_management.presentation.dto.response.VehicleResponseDto;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {

    public VehicleResponseDto toResponse(VehicleEntity entity) {
        return new VehicleResponseDto(
                entity.getId(),
                entity.getBrand(),
                entity.getModel(),
                entity.getManufactureYear(),
                entity.getOwner().getId(),
                entity.getOwner().getName()
        );
    }
}
