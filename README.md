# 📦 CRUD Pedidos API

API RESTful para gerenciamento de pedidos, clientes e produtos. Construída com **Spring Boot 3**, **Gradle**, **PostgreSQL** e **Flyway** para migrations.

> 🔄 **Refatoração completa** do [projeto original](https://github.com/Victoredbr21/projeto-crud-pedidos-java) — de um exercício de console para uma API REST de produção.

---

## 🛠️ Tecnologias

| Tecnologia | Versão | Uso |
|---|---|---|
| Java | 21 | Linguagem |
| Spring Boot | 3.3.0 | Framework principal |
| Spring Web | 3.3.0 | API REST |
| Spring Data JPA | 3.3.0 | Acesso a dados |
| Spring Validation | 3.3.0 | Validação de DTOs |
| Flyway | 10.x | Migrations do banco |
| PostgreSQL | 15+ | Banco de dados |
| Lombok | latest | Redução de boilerplate |
| Gradle | 8.x | Build tool |

---

## 📁 Estrutura do Projeto

```
src/main/java/com/pedidos/
├── CrudPedidosApplication.java     # Entry point
├── controller/
│   ├── ClientController.java       # CRUD clientes
│   ├── ProductController.java      # CRUD produtos
│   └── OrderController.java        # CRUD pedidos
├── service/
│   ├── ClientService.java
│   ├── ProductService.java
│   └── OrderService.java
├── repository/
│   ├── ClientRepository.java
│   ├── ProductRepository.java
│   └── OrderRepository.java
├── entity/
│   ├── Client.java
│   ├── Product.java
│   ├── Order.java
│   └── OrderItem.java
├── dto/
│   ├── ClientRequestDTO.java / ClientResponseDTO.java
│   ├── ProductRequestDTO.java / ProductResponseDTO.java
│   ├── OrderRequestDTO.java / OrderResponseDTO.java
│   ├── OrderItemRequestDTO.java / OrderItemResponseDTO.java
│   └── UpdateOrderStatusDTO.java
├── enums/
│   └── OrderStatus.java            # WAITING, CANCELED, PAID, SHIPPED, DELIVERED
└── exception/
    ├── ResourceNotFoundException.java
    ├── BusinessException.java
    └── GlobalExceptionHandler.java

src/main/resources/
├── application.properties
├── application-test.properties
└── db/migration/
    ├── V1__create_tables.sql       # DDL das tabelas
    └── V2__seed_data.sql           # Dados iniciais
```

---

## ⚙️ Como executar

### Pré-requisitos
- Java 21+
- PostgreSQL 15+
- Gradle 8+ (ou use o wrapper `./gradlew`)

### 1. Crie o banco de dados

```sql
CREATE DATABASE pedidos_db;
```

### 2. Configure as credenciais

Edite `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/pedidos_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

### 3. Execute

```bash
./gradlew bootRun
```

O Flyway rodará as migrations automaticamente na primeira inicialização.

A API ficará disponível em: `http://localhost:8080`

---

## 🌐 Endpoints

### Clientes `/api/clients`

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/api/clients` | Lista todos os clientes |
| GET | `/api/clients/{id}` | Busca cliente por ID |
| POST | `/api/clients` | Cria novo cliente |
| PUT | `/api/clients/{id}` | Atualiza cliente |
| DELETE | `/api/clients/{id}` | Remove cliente |

### Produtos `/api/products`

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/api/products` | Lista todos os produtos |
| GET | `/api/products/{id}` | Busca produto por ID |
| POST | `/api/products` | Cria novo produto |
| PUT | `/api/products/{id}` | Atualiza produto |
| DELETE | `/api/products/{id}` | Remove produto |

### Pedidos `/api/orders`

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/api/orders` | Lista todos os pedidos |
| GET | `/api/orders?clientId={id}` | Pedidos por cliente |
| GET | `/api/orders?status={status}` | Pedidos por status |
| GET | `/api/orders/{id}` | Busca pedido por ID |
| POST | `/api/orders` | Cria novo pedido |
| PATCH | `/api/orders/{id}/status` | Atualiza status do pedido |
| DELETE | `/api/orders/{id}` | Remove pedido |

---

## 📋 Exemplos de Requisições

### Criar cliente
```json
POST /api/clients
{
  "name": "Victor Eduardo",
  "email": "victor@email.com",
  "birthDate": "1996-05-14"
}
```

### Criar pedido
```json
POST /api/orders
{
  "clientId": 1,
  "status": "WAITING",
  "items": [
    { "productId": 1, "quantity": 2 },
    { "productId": 3, "quantity": 1 }
  ]
}
```

### Atualizar status
```json
PATCH /api/orders/1/status
{
  "status": "PAID"
}
```

### Status disponíveis (em ordem)
```
WAITING → PAID → SHIPPED → DELIVERED
         ↓
      CANCELED
```

---

## 🧪 Testes

```bash
./gradlew test
```

O perfil de testes usa H2 em memória — sem precisar de PostgreSQL rodando.

---

## 🔗 Origem do Projeto

Refatoração completa do projeto `projeto-crud-pedidos-java`, originalmente um exercício do curso do [Nélio Alves](https://devsuperior.com.br) (Java COMPLETO). O exercício original usava leitura de console sem persistência; esta versão o transforma em uma API REST completa.

