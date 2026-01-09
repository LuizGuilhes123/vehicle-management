package com.company.vehicle_management.application.service.impl;



import com.company.vehicle_management.presentation.dto.request.VehicleRequestDto;
import com.company.vehicle_management.presentation.dto.response.VehicleResponseDto;

import java.util.List;

public interface VehicleService {

    VehicleResponseDto criar(VehicleRequestDto request);

    VehicleResponseDto buscarPorId(Long id);

    List<VehicleResponseDto> listarTodos();

    VehicleResponseDto atualizar(Long id, VehicleRequestDto request);

    void deletar(Long id);
}
