package com.company.vehicle_management.application.service;



import com.company.vehicle_management.presentation.dto.request.ClientRequestDto;
import com.company.vehicle_management.presentation.dto.response.ClientResponseDto;

import java.util.List;

public interface ClientService {

    ClientResponseDto criar(ClientRequestDto request);

    List<ClientResponseDto> listarTodos();
}
