package com.company.vehicle_management.presentation.controller;


import com.company.vehicle_management.application.service.ClientService;
import com.company.vehicle_management.presentation.dto.request.ClientRequestDto;
import com.company.vehicle_management.presentation.dto.response.ClientResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @PostMapping
    public ResponseEntity<ClientResponseDto> criar(
            @Valid @RequestBody ClientRequestDto request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.criar(request));
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDto>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }
}
