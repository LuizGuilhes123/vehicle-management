package com.company.vehicle_management.presentation.controller;


import com.company.vehicle_management.application.service.VehicleService;
import com.company.vehicle_management.presentation.dto.request.VehicleRequestDto;
import com.company.vehicle_management.presentation.dto.response.VehicleResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService service;

    @PostMapping
    public ResponseEntity<VehicleResponseDto> criar(
            @Valid @RequestBody VehicleRequestDto request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.criar(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<VehicleResponseDto>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleResponseDto> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody VehicleRequestDto request
    ) {
        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
