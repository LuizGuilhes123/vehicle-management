-- =========================================
-- Schema: Vehicle Management
-- Banco: MySQL 8+
-- =========================================

CREATE DATABASE IF NOT EXISTS vehicle_db;
USE vehicle_db;

-- =========================
-- Tabela: clients
-- =========================
CREATE TABLE IF NOT EXISTS clients (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- =========================
-- Tabela: vehicles
-- =========================
CREATE TABLE IF NOT EXISTS vehicles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    brand VARCHAR(100) NOT NULL,
    model VARCHAR(100) NOT NULL,
    manufacture_year INT NOT NULL,
    plate VARCHAR(20) UNIQUE,
    client_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_vehicle_client
        FOREIGN KEY (client_id)
        REFERENCES clients(id)
        ON DELETE CASCADE
);

-- =========================
-- Índices auxiliares
-- =========================
CREATE INDEX idx_vehicle_client ON vehicles(client_id);
CREATE INDEX idx_client_email ON clients(email);
