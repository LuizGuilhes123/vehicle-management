package com.company.vehicle_management.domain.repository;


import com.company.vehicle_management.domain.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {
}
