package com.company.vehicle_management.application.service.impl;

import com.company.vehicle_management.domain.entity.ClientEntity;
import com.company.vehicle_management.domain.entity.VehicleEntity;
import com.company.vehicle_management.domain.repository.ClientRepository;
import com.company.vehicle_management.domain.repository.VehicleRepository;
import com.company.vehicle_management.exception.ResourceNotFoundException;
import com.company.vehicle_management.infrastructure.mapper.VehicleMapper;
import com.company.vehicle_management.presentation.dto.request.VehicleRequestDto;
import com.company.vehicle_management.presentation.dto.response.VehicleResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VehicleServiceImplTest {

    @Mock
    private VehicleRepository vehicleRepository;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private VehicleMapper mapper;

    @InjectMocks
    private VehicleServiceImpl service;

    @Test
    void deveCriarVeiculoComSucesso() {
        var request = new VehicleRequestDto("Toyota", "Corolla", 2020, 1L);

        var client = ClientEntity.builder().id(1L).name("João").build();

        var entity = VehicleEntity.builder()
                .id(10L)
                .brand("Toyota")
                .model("Corolla")
                .manufactureYear(2020)
                .owner(client)
                .build();

        var response = new VehicleResponseDto(10L, "Toyota", "Corolla", 2020, 1L, "João");

        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));
        when(vehicleRepository.save(any())).thenReturn(entity);
        when(mapper.toResponse(entity)).thenReturn(response);

        var result = service.criar(request);

        assertNotNull(result);
        assertEquals("Toyota", result.brand());
        assertEquals("João", result.clientName());

        verify(vehicleRepository).save(any());
    }

    @Test
    void deveBuscarVeiculoPorIdComSucesso() {
        var client = ClientEntity.builder().id(1L).name("João").build();

        var entity = VehicleEntity.builder()
                .id(10L)
                .brand("Toyota")
                .model("Corolla")
                .manufactureYear(2020)
                .owner(client)
                .build();

        var response = new VehicleResponseDto(10L, "Toyota", "Corolla", 2020, 1L, "João");

        when(vehicleRepository.findById(10L)).thenReturn(Optional.of(entity));
        when(mapper.toResponse(entity)).thenReturn(response);

        var result = service.buscarPorId(10L);

        assertNotNull(result);
        assertEquals(10L, result.id());

        verify(vehicleRepository).findById(10L);
    }

    @Test
    void deveLancarErroQuandoVeiculoNaoExiste() {
        when(vehicleRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> service.buscarPorId(99L));
    }

    @Test
    void deveDeletarVeiculoComSucesso() {
        when(vehicleRepository.existsById(10L)).thenReturn(true);

        service.deletar(10L);

        verify(vehicleRepository).deleteById(10L);
    }
}
