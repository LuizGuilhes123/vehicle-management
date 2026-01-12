# Vehicle Management API

Projeto backend profissional desenvolvido em **Java 17 + Spring Boot**, seguindo princípios de **Clean Architecture**, **boas práticas de mercado** e organização voltada para manutenibilidade, escalabilidade e clareza técnica.

Este repositório simula um sistema real de gerenciamento de veículos e clientes, com CRUD completo, validações, documentação e integração com banco de dados relacional.

---

## 📌 Visão Geral do Projeto

A **Vehicle Management API** é uma aplicação REST responsável por gerenciar:
- Clientes
- Veículos vinculados aos clientes

O sistema foi projetado com separação clara de responsabilidades entre camadas:
- Controller (entrada HTTP)
- Service (regras de negócio)
- Repository (persistência)
- DTOs (contratos de entrada e saída)
- Entities (modelo de domínio)

---

## 🧱 Arquitetura e Organização

- Arquitetura em camadas (inspirada em Clean Architecture)
- Separação entre domínio, aplicação e infraestrutura
- DTOs para evitar exposição direta das entidades
- Exceptions personalizadas
- Mapeamento centralizado (Mapper)
- Código preparado para testes unitários

Estrutura simplificada:

```
com.company.vehicle_management
├── controller
├── service
│   └── impl
├── repository
├── domain
│   └── entity
├── dto
│   ├── request
│   └── response
├── mapper
├── exception
└── config
```

---

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Lombok
- Swagger / OpenAPI
- Maven
- Postman

---

## ⚙️ Configuração do Ambiente

### Pré-requisitos

- Java 17+
- Maven 3.9+
- MySQL 8+
- Postman (opcional, para testes)

### Banco de dados

Crie o banco manualmente:

```sql
CREATE DATABASE vehicle_db;
```

O projeto utiliza o arquivo `schema.sql` para criação automática das tabelas.

---

## ▶️ Executando o Projeto

```bash
mvn clean install
mvn spring-boot:run
```

A aplicação estará disponível em:

```
http://localhost:8080
```

Swagger UI:

```
http://localhost:8080/swagger-ui.html
```

---

## 📬 Collection do Postman

### Endpoints disponíveis

#### Cliente
- POST `/clients`
- GET `/clients/{id}`
- GET `/clients`
- PUT `/clients/{id}`
- DELETE `/clients/{id}`

#### Veículo
- POST `/vehicles`
- GET `/vehicles/{id}`
- GET `/vehicles`
- PUT `/vehicles/{id}`
- DELETE `/vehicles/{id}`

---

### Exemplo de payload (POST /vehicles)

```json
{
  "brand": "Toyota",
  "model": "Corolla",
  "manufactureYear": 2022,
  "clientId": 1
}
```

---

## 🗃️ schema.sql atualizado

```sql
CREATE TABLE clients (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE
);

CREATE TABLE vehicles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    brand VARCHAR(100) NOT NULL,
    model VARCHAR(100) NOT NULL,
    manufacture_year INT NOT NULL,
    client_id BIGINT NOT NULL,
    CONSTRAINT fk_vehicle_client
        FOREIGN KEY (client_id)
        REFERENCES clients(id)
        ON DELETE CASCADE
);
```

---

## 🧠 Conceitos Aplicados

- DTO Pattern
- SOLID (Responsabilidade Única aplicada nos serviços)
- Exceptions customizadas
- Validação de regras de negócio
- Encapsulamento do domínio
- Pronto para evolução com testes automatizados

---

## 📈 Qualidade do Código

O projeto foi estruturado visando:

- Alta legibilidade
- Fácil manutenção
- Baixo acoplamento
- Código orientado a domínio
- Organização compatível com projetos reais de mercado

---

## 👨‍💻 Autor

Luiz Guilherme  
Desenvolvedor Full Stack  
Java | Spring Boot | Clean Architecture | SQL | Docker | CI/CD

---

Se desejar, posso complementar com:
- Collection do Postman em JSON exportável
- Testes unitários (JUnit + Mockito)
- Docker Compose (API + MySQL)
- Pipeline CI/CD

