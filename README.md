# 📌 Spring Bean Validation - Example Project

Projeto desenvolvido para demonstrar na prática a validação de dados em APIs REST utilizando Bean Validation no Spring Boot.

---

## 🧠 Objetivo

O objetivo deste projeto é garantir que os dados recebidos pela API sejam validados antes do processamento, evitando inconsistências, erros de negócio e melhorando a segurança da aplicação.

---

## 🚀 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Bean Validation (Hibernate Validator)
- H2 Database (ou outro)

---

## 🧱 Arquitetura do projeto

- **DTO** → Validação dos dados de entrada  
- **Entity** → Representação do banco de dados  
- **Controller** → Entrada da API  
- **Repository** → Persistência  
- **Exception Handler** → Tratamento global de erros  

---

## 📦 DTO com Record

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

✅ Benefícios:
Menos código boilerplate
Imutabilidade
Mais segurança

🔄 Conversão DTO → Entity

A conversão dos dados é feita através de um método toEntity() dentro do DTO, mantendo o código limpo e organizado.

📌 Endpoint
➤ Criar usuário

POST /users

📥 Exemplo de requisição
{
  "name": "Hugo",
  "email": "hugo@email.com"
}

❌ Exemplo de requisição inválida
{
  "name": "",
  "email": "email-invalido"
}

🚨 Tratamento de erros

A aplicação possui um tratamento global de exceções utilizando @RestControllerAdvice.

📤 Resposta de erro
{
  "status": 400,
  "message": "Validation error",
  "errors": [
    {
      "field": "name",
      "error": "Name is mandatory"
    },
    {
      "field": "email",
      "error": "Invalid email address"
    }
  ]
}

🧠 Conceitos abordados
Validação com Bean Validation:
@NotBlank
@Email
@Size
Uso de @Valid no Controller
Separação entre DTO e Entity
Uso de Java Records
Tratamento global de exceções
Padronização de respostas de erro

✅ Benefícios da validação
Evita dados inconsistentes
Garante integridade das informações
Melhora a segurança da aplicação
Facilita o consumo da API por clientes

📖 Referências
https://www.baeldung.com/spring-boot-bean-validation

👨‍💻 Autor

Desenvolvido por Hugo Torres
🔗 https://github.com/Hugoftf
