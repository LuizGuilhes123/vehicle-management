# Vehicle Management API

API REST profissional desenvolvida em **Java 17 + Spring Boot**,
seguindo princípios de **Clean Architecture**, boas práticas de mercado
e organização voltada para **manutenibilidade, escalabilidade e clareza
técnica**.

Este projeto simula um sistema real de gerenciamento de veículos e
clientes, com **CRUD completo**, validações, documentação, autenticação
e integração com banco de dados relacional.

------------------------------------------------------------------------

## 📌 Visão Geral do Projeto

A **Vehicle Management API** é responsável por gerenciar:

-   Clientes\
-   Veículos vinculados aos clientes\
-   Autenticação de usuários via JWT

O sistema foi projetado com separação clara de responsabilidades entre
camadas:

-   Controller (entrada HTTP)\
-   Service (regras de negócio)\
-   Repository (persistência)\
-   DTOs (contratos de entrada e saída)\
-   Entities (modelo de domínio)\
-   Security (controle de autenticação e autorização)

------------------------------------------------------------------------

## 🧱 Arquitetura e Organização

-   Arquitetura em camadas inspirada em Clean Architecture\
-   Separação entre domínio, aplicação, infraestrutura e apresentação\
-   DTOs para evitar exposição direta das entidades\
-   Exceptions personalizadas\
-   Mapeamento centralizado (Mapper)\
-   Estrutura preparada para testes unitários\
-   Autenticação via JWT

Estrutura simplificada do projeto:

    com.company.vehicle_management
    ├── application
    │   └── service
    │       └── impl
    ├── domain
    │   ├── entity
    │   └── repository
    ├── infrastructure
    │   └── mapper
    ├── presentation
    │   ├── controller
    │   └── dto
    │       ├── request
    │       └── response
    ├── security
    ├── exception
    └── config

------------------------------------------------------------------------

## 🚀 Tecnologias Utilizadas

-   Java 17\
-   Spring Boot 3.x\
-   Spring Web\
-   Spring Data JPA\
-   Hibernate\
-   Spring Security\
-   JWT (JSON Web Token)\
-   MySQL\
-   Lombok\
-   Swagger / OpenAPI\
-   Maven\
-   Postman

------------------------------------------------------------------------

## ⚙️ Configuração do Ambiente

### Pré-requisitos

-   Java 17+\
-   Maven 3.9+\
-   MySQL 8+\
-   Postman (opcional, para testes)

### Banco de dados

Crie o banco manualmente:

``` sql
CREATE DATABASE vehicle_db;
```

O projeto utiliza o arquivo `schema.sql` para criação automática das
tabelas.

------------------------------------------------------------------------

## ▶️ Executando o Projeto

``` bash
mvn clean install
mvn spring-boot:run
```

A aplicação estará disponível em:

    http://localhost:8080

Swagger UI (documentação interativa):

    http://localhost:8080/swagger-ui/index.html

------------------------------------------------------------------------

## 🔐 Autenticação

O projeto possui autenticação baseada em **JWT (JSON Web Token)**.

Fluxo:

1.  O usuário realiza login em `/auth/login`\
2.  Recebe um token JWT\
3.  O token deve ser enviado no header das requisições protegidas:

```{=html}
<!-- -->
```
    Authorization: Bearer SEU_TOKEN_AQUI

------------------------------------------------------------------------

## 📬 Collection do Postman

O projeto inclui uma **Collection do Postman pronta para uso**,
contendo:

-   Login (JWT)\
-   CRUD completo de Clientes\
-   CRUD completo de Veículos\
-   Exemplos de payloads prontos

📂 Arquivo disponível no repositório:

    Vehicle Management API.postman_collection.json

Para utilizar: 1. Abra o Postman\
2. Clique em **Import**\
3. Selecione o arquivo `.json` da collection\
4. Execute as requisições normalmente

------------------------------------------------------------------------

## 📌 Endpoints disponíveis

### Autenticação

-   POST `/auth/login`

### Cliente

-   POST `/clients`\
-   GET `/clients/{id}`\
-   GET `/clients`\
-   PUT `/clients/{id}`\
-   DELETE `/clients/{id}`

### Veículo

-   POST `/vehicles`\
-   GET `/vehicles/{id}`\
-   GET `/vehicles`\
-   PUT `/vehicles/{id}`\
-   DELETE `/vehicles/{id}`

------------------------------------------------------------------------

## 📦 Exemplo de payload

### Criar veículo (POST `/vehicles`)

``` json
{
  "brand": "Toyota",
  "model": "Corolla",
  "manufactureYear": 2022,
  "clientId": 1
}
```

------------------------------------------------------------------------

## 🗃️ DDL -- schema.sql

O projeto inclui o arquivo `schema.sql` com a definição das tabelas:

``` sql
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

------------------------------------------------------------------------

## 🧠 Conceitos Aplicados

-   DTO Pattern\
-   SOLID (Responsabilidade Única nos serviços)\
-   Exceptions customizadas\
-   Validação com Bean Validation\
-   Encapsulamento do domínio\
-   Autenticação JWT\
-   Separação clara de camadas\
-   Organização compatível com projetos reais de mercado

------------------------------------------------------------------------

## 📈 Qualidade do Código

O projeto foi estruturado visando:

-   Alta legibilidade\
-   Fácil manutenção\
-   Baixo acoplamento\
-   Código orientado a domínio\
-   Organização compatível com aplicações profissionais\
-   Estrutura preparada para testes automatizados

------------------------------------------------------------------------

## 👨‍💻 Autor

Luiz Guilherme\
Desenvolvedor Full Stack\
Java \| Spring Boot \| Clean Architecture \| SQL \| Docker \| CI/CD

------------------------------------------------------------------------

## 📌 Observação Final

Este projeto foi desenvolvido como parte de um **desafio técnico para
vaga de Analista de Desenvolvimento Java Pleno**, buscando refletir
práticas reais de mercado e qualidade de código profissional.
