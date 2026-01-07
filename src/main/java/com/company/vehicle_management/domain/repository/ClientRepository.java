package com.company.vehicle_management.domain.repository;


import com.company.vehicle_management.domain.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    boolean existsByEmail(String email);
}
