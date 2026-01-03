# 🥷 Sistema de Cadastro de Ninjas

Sistema de gerenciamento de ninjas e missões desenvolvido com Spring Boot, utilizando JPA/Hibernate e banco de dados H2 em memória.

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot 4.0.1
- Spring Data JPA
- H2 Database (em memória)
- Lombok
- Maven

## 📋 Pré-requisitos

- JDK 21 ou superior
- Maven (ou usar o wrapper mvnw incluído)

## ⚙️ Como Executar

### Windows
```powershell
.\mvnw spring-boot:run
```

### Linux/Mac
```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

## 🗄️ Banco de Dados H2

Console H2 disponível em: `http://localhost:8080/h2-console`

**Credenciais:**
- JDBC URL: `jdbc:h2:mem:cadastrodb`
- Username: `sa`
- Password: _(deixar em branco)_

## 📡 Endpoints da API

### Ninjas

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/ninjas` | Lista todos os ninjas |
| GET | `/ninjas/{id}` | Busca ninja por ID |
| GET | `/ninjas/buscar?nome={nome}` | Busca ninjas por nome |
| GET | `/ninjas/idade/{idade}` | Busca ninjas por idade |
| POST | `/ninjas` | Cria um novo ninja |
| PUT | `/ninjas/{id}` | Atualiza um ninja |
| DELETE | `/ninjas/{id}` | Remove um ninja |

### Missões

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/missoes` | Lista todas as missões |
| GET | `/missoes/{id}` | Busca missão por ID |
| GET | `/missoes/buscar?nome={nome}` | Busca missões por nome |
| GET | `/missoes/dificuldade/{dificuldade}` | Busca missões por dificuldade |
| POST | `/missoes` | Cria uma nova missão |
| PUT | `/missoes/{id}` | Atualiza uma missão |
| DELETE | `/missoes/{id}` | Remove uma missão |

## 📝 Exemplos de Uso

### Criar uma Missão

**POST** `http://localhost:8080/missoes`

```json
{
  "nomeMissao": "Recuperar Pergaminho Secreto",
  "dificuldade": "Difícil"
}
```

### Criar um Ninja (sem missão)

**POST** `http://localhost:8080/ninjas`

```json
{
  "nome": "Naruto Uzumaki",
  "email": "naruto@konoha.com",
  "idade": 17
}
```

### Criar um Ninja com Missão

**POST** `http://localhost:8080/ninjas`

```json
{
  "nome": "Kakashi Hatake",
  "email": "kakashi@konoha.com",
  "idade": 27,
  "missoes": {
    "id": 1
  }
}
```

### Atualizar um Ninja

**PUT** `http://localhost:8080/ninjas/1`

```json
{
  "nome": "Naruto Uzumaki",
  "email": "naruto@konoha.com",
  "idade": 18,
  "missoes": {
    "id": 1
  }
}
```

### Deletar um Ninja

**DELETE** `http://localhost:8080/ninjas/1`

### Listar Todos os Ninjas

**GET** `http://localhost:8080/ninjas`

### Buscar Ninja por Nome

**GET** `http://localhost:8080/ninjas/buscar?nome=Naruto`

## 🏗️ Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/primeiroSistemaSpring/CadastroDeNinjas/
│   │   ├── controller/          # Controladores REST
│   │   │   ├── NinjaController.java
│   │   │   └── MissoesController.java
│   │   ├── model/               # Entidades JPA
│   │   │   ├── Ninja.java
│   │   │   └── Missoes.java
│   │   ├── repository/          # Repositórios JPA
│   │   │   ├── NinjaRepository.java
│   │   │   └── MissoesRepository.java
│   │   ├── service/             # Camada de serviço
│   │   │   ├── NinjaService.java
│   │   │   └── MissoesService.java
│   │   └── CadastroDeNinjasApplication.java
│   └── resources/
│       └── application.properties
└── test/
```

## 🔗 Relacionamentos

- **Ninja ↔ Missões**: Relacionamento Many-to-One
  - Vários ninjas podem participar da mesma missão
  - Uma missão pode ter vários ninjas associados

## 📦 Dependências Principais

```xml
<dependencies>
    <!-- Spring Boot Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-webmvc</artifactId>
    </dependency>
    
    <!-- Spring Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    
    <!-- H2 Database -->
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    
    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```

## 👤 Autor

Carlos

## 📄 Licença

Este projeto foi desenvolvido para fins educacionais.
