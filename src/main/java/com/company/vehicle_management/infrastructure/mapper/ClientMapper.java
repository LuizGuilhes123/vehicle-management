package com.company.vehicle_management.infrastructure.mapper;


import com.company.vehicle_management.domain.entity.ClientEntity;
import com.company.vehicle_management.presentation.dto.request.ClientRequestDto;
import com.company.vehicle_management.presentation.dto.response.ClientResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientEntity toEntity(ClientRequestDto dto) {
        return ClientEntity.builder()
                .name(dto.name())
                .email(dto.email())
                .document(dto.document())
                .build();
    }

    public ClientResponseDto toResponse(ClientEntity entity) {
        return new ClientResponseDto(
                entity.getId(),
                entity.getName(),
                entity.getEmail()
        );
    }
}
