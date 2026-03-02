# 🏦 Bank System – Microservices Architecture

A banking system built using a microservices architecture with:

- Spring Boot 3
- PostgreSQL
- Angular 19 (Standalone)
- OpenFeign
- Docker & Docker Compose

---

## 📦 Services

### 1️⃣ bank-service
Handles:
- Clientes
- Cuentas
- Movimientos

Runs on: http://localhost:8080

---

### 2️⃣ report-service
Generates:
- Client account reports
- Movement history reports

Uses OpenFeign to communicate with bank-service.

Runs on: http://localhost:8081

---

### 3️⃣ bank-ui
Angular frontend consuming both services.

Runs on: http://localhost:4200

---

### 4️⃣ PostgreSQL
Database initialized automatically using:

```
db-init.sql
```

Includes:
- Schema creation
- Mock data insertion

---

# 🚀 Run Entire System

From project root:

```bash
docker-compose down -v
docker-compose up --build
```

This will:

- Start PostgreSQL
- Initialize schema
- Insert mock data
- Build bank-service
- Build report-service
- Build Angular UI
- Connect all services

---

# 🗄 Database Schema

Tables:

- persona
- cliente
- cuenta
- movimiento

All foreign keys and indexes included.

---

# 🔌 API Endpoints

## Bank Service

GET /api/v1/clientes/{clienteId}

GET /api/v1/cuentas/cliente/{clienteId}

GET /api/v1/movimientos/cuenta/{cuentaId}

---

## Report Service

GET /api/v1/reportes?clienteId=CLI-001&from=2024-01-01T00:00:00&to=2024-12-31T23:59:59

---

# 🐳 Docker Architecture

All services communicate using Docker internal networking.

Example:

```
report-service → http://bank-service:8080
```

No localhost is used between containers.

---

# 🛠 Tech Stack

- Java 21
- Spring Boot 3
- Spring Data JPA
- Spring Cloud OpenFeign
- PostgreSQL 15
- Angular 19 (Standalone)
- Docker
- Docker Compose

---

# 📂 Project Structure

```
root/
 ├── bank-service/
 ├── report-service/
 ├── bank-ui/
 ├── db-init.sql
 └── docker-compose.yml
```

---

# 🧪 Mock Data

Two clients are preloaded:

- CLI-001
- CLI-002

Each with accounts and movements.

---

# 📌 Notes

- PostgreSQL initialization runs only on first container creation.
- Use `docker-compose down -v` to reset database.

---

# 👨‍💻 Author

Igor
Software Engineer