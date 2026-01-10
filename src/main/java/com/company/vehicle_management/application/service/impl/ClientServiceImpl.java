package com.company.vehicle_management.application.service.impl;


import com.company.vehicle_management.application.service.ClientService;
import com.company.vehicle_management.domain.repository.ClientRepository;
import com.company.vehicle_management.infrastructure.mapper.ClientMapper;
import com.company.vehicle_management.presentation.dto.request.ClientRequestDto;
import com.company.vehicle_management.presentation.dto.response.ClientResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;
    private final ClientMapper mapper;

    @Override
    public ClientResponseDto criar(ClientRequestDto request) {
        var entity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public List<ClientResponseDto> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ClientResponseDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    @Override
    public ClientResponseDto atualizar(Long id, ClientRequestDto request) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        entity.setName(request.name());
        entity.setEmail(request.email());
        entity.setDocument(request.document());

        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado");
        }
        repository.deleteById(id);
    }
}
