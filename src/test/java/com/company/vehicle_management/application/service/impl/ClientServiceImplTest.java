package com.company.vehicle_management.application.service.impl;

import com.company.vehicle_management.domain.entity.ClientEntity;
import com.company.vehicle_management.domain.repository.ClientRepository;
import com.company.vehicle_management.exception.ResourceNotFoundException;
import com.company.vehicle_management.infrastructure.mapper.ClientMapper;
import com.company.vehicle_management.presentation.dto.request.ClientRequestDto;
import com.company.vehicle_management.presentation.dto.response.ClientResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {

    @Mock
    private ClientRepository repository;

    @Mock
    private ClientMapper mapper;

    @InjectMocks
    private ClientServiceImpl service;

    @Test
    void deveCriarClienteComSucesso() {
        var request = new ClientRequestDto("João", "joao@email.com", "123");

        var entity = ClientEntity.builder()
                .id(1L)
                .name("João")
                .email("joao@email.com")
                .document("123")
                .build();

        var responseDto = new ClientResponseDto(1L, "João", "joao@email.com");

        when(mapper.toEntity(request)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toResponse(entity)).thenReturn(responseDto);

        var response = service.criar(request);

        assertNotNull(response);
        assertEquals(1L, response.id());
        assertEquals("João", response.name());
        assertEquals("joao@email.com", response.email());

        verify(mapper).toEntity(request);
        verify(repository).save(entity);
        verify(mapper).toResponse(entity);
    }

    @Test
    void deveBuscarClientePorIdComSucesso() {
        var entity = ClientEntity.builder().id(1L).name("João").email("joao@email.com").build();
        var response = new ClientResponseDto(1L, "João", "joao@email.com");

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(mapper.toResponse(entity)).thenReturn(response);

        var result = service.buscarPorId(1L);

        assertNotNull(result);
        assertEquals(1L, result.id());

        verify(repository).findById(1L);
    }

    @Test
    void deveLancarExcecaoQuandoClienteNaoEncontrado() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> service.buscarPorId(99L));
    }

    @Test
    void deveDeletarClienteComSucesso() {
        when(repository.existsById(1L)).thenReturn(true);

        service.deletar(1L);

        verify(repository).deleteById(1L);
    }
}
