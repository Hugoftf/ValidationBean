# 📌 Spring Bean Validation - Example Project

Projeto desenvolvido para demonstrar na prática a validação de dados em APIs REST utilizando Bean Validation no Spring Boot.

---

## 🧠 Objetivo

O objetivo deste projeto é garantir que os dados recebidos pela API sejam validados antes do processamento, evitando inconsistências, erros de negócio e melhorando a segurança da aplicação.

---

## 🚀 Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Bean Validation (Hibernate Validator)
- H2 Database (ou outro, se estiver usando)

---

## 🧱 Arquitetura do projeto

A aplicação segue o princípio de separação de responsabilidades:

- **DTO** → Responsável pela validação dos dados de entrada  
- **Entity** → Representa a estrutura do banco de dados  
- **Controller** → Camada de entrada da API  
- **Repository** → Persistência de dados  
- **Exception Handler** → Tratamento global de erros  

---

## 📦 DTO com Record

Os DTOs foram implementados utilizando `record`, um recurso do Java que permite criar objetos imutáveis de forma simples e eficiente.

```java
public record UserDTO(
    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 50)
    String name,

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Invalid email address")
    String email
) {
    public User toEntity() {
        return new User(name, email);
    }
}
