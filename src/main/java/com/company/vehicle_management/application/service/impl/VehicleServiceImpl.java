package com.company.vehicle_management.application.service.impl;


import com.company.vehicle_management.application.service.VehicleService;
import com.company.vehicle_management.domain.entity.VehicleEntity;
import com.company.vehicle_management.domain.repository.ClientRepository;
import com.company.vehicle_management.domain.repository.VehicleRepository;
import com.company.vehicle_management.infrastructure.mapper.VehicleMapper;
import com.company.vehicle_management.presentation.dto.request.VehicleRequestDto;
import com.company.vehicle_management.presentation.dto.response.VehicleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final ClientRepository clientRepository;
    private final VehicleMapper mapper;

    @Override
    public VehicleResponseDto criar(VehicleRequestDto request) {
        var client = clientRepository.findById(request.clientId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        var entity = VehicleEntity.builder()
                .brand(request.brand())
                .model(request.model())
                .manufactureYear(request.manufactureYear())
                .owner(client)
                .build();

        return mapper.toResponse(vehicleRepository.save(entity));
    }

    @Override
    @Transactional(readOnly = true)
    public VehicleResponseDto buscarPorId(Long id) {
        return vehicleRepository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehicleResponseDto> listarTodos() {
        return vehicleRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public VehicleResponseDto atualizar(Long id, VehicleRequestDto request) {
        var entity = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        var client = clientRepository.findById(request.clientId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        entity.setBrand(request.brand());
        entity.setModel(request.model());
        entity.setManufactureYear(request.manufactureYear());
        entity.setOwner(client);

        return mapper.toResponse(vehicleRepository.save(entity));
    }

    @Override
    public void deletar(Long id) {
        if (!vehicleRepository.existsById(id)) {
            throw new RuntimeException("Veículo não encontrado");
        }
        vehicleRepository.deleteById(id);
    }
}
