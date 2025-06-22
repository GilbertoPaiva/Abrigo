# Shelter Management System

Sistema de gestão de abrigos desenvolvido com Spring Boot seguindo a arquitetura hexagonal (Ports and Adapters).

## Estrutura do Projeto

```
com.shelter.management/
├── application/
│   ├── ports/
│   │   ├── in/         # Use Cases (interfaces que definem o que a aplicação pode fazer)
│   │   └── out/        # Repository Interfaces (interfaces para acesso a dados)
│   ├── services/       # Implementação dos Use Cases
│   └── dto/           # Data Transfer Objects
├── domain/
│   ├── entities/      # Entidades de domínio
│   ├── enums/         # Enumerações
│   └── exceptions/    # Exceções de domínio
├── infrastructure/
│   ├── adapters/
│   │   ├── in/
│   │   │   └── rest/  # Controllers REST
│   │   └── out/
│   │       └── persistence/ # Implementações JPA dos repositórios
│   ├── config/        # Configurações do Spring
│   └── migrations/    # Scripts de migração do banco
└── ShelterManagementApplication.java
```

## Arquitetura Hexagonal

Esta estrutura segue os princípios da arquitetura hexagonal:

- **Domain**: Contém a lógica de negócio pura, independente de frameworks
- **Application**: Contém os casos de uso e coordena as operações
- **Infrastructure**: Contém implementações específicas de frameworks e tecnologias

## Como executar

```bash
mvn spring-boot:run
```

## Tecnologias

- Java 17
- Spring Boot 3.2.0
- Spring Data JPA
- H2 Database (para desenvolvimento)
- Maven
