# TymelessTyre — Backend API

A RESTful backend for **TymelessTyre**, a full-stack e-commerce platform for purchasing tyres online and booking automotive services.

> 🚧 **Status:** Backend is stable. Frontend refactor currently in progress.

---

## About

TymelessTyre allows customers to browse and purchase tyres online and schedule automotive service appointments. This repository contains the secure Spring Boot REST API.

The frontend repository lives here → [Tymelesstyre-frontend](https://github.com/Siphokuhle-222357614/Tymelesstyre-frontend)

---

## Tech Stack

| Layer | Technology |
|-------|------------|
| Language | Java 21 |
| Framework | Spring Boot 3.1.4 |
| Security | Spring Security + JWT (jjwt 0.11.5) |
| Database | MySQL 8 |
| ORM | Spring Data JPA |
| Validation | Apache Commons Validator |
| Testing | JUnit 5 + Spring Boot Test |
| Build Tool | Maven |

---

## Features

- JWT-based authentication and authorisation
- Tyre product catalogue with listings and pricing
- Customer order management
- Automotive service booking and scheduling
- Input validation via Apache Commons Validator
- RESTful API consumed by the Vue.js frontend

---

## Getting Started

### Prerequisites

- Java 21+
- Maven 3.8+
- MySQL 8+

### Installation

1. Clone the repository

```bash
git clone https://github.com/Siphokuhle-222357614/TymelessTyre.git
cd TymelessTyre
```

2. Create a MySQL database

```sql
CREATE DATABASE tymelesstyre;
```

3. Configure `src/main/resources/application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tymelesstyre
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

4. Build and run

```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

---

## Project Structure

```
src/
└── main/
    ├── java/
    │   └── za/co/tt/
    │       ├── controller/
    │       ├── service/
    │       ├── repository/
    │       ├── model/
    │       ├── dto/
    │       └── security/
    └── resources/
        └── application.properties
```

---

## Running Tests

```bash
mvn test
```

---

## Related Repository

🖥️ **Frontend:** [Tymelesstyre-frontend](https://github.com/Siphokuhle-222357614/Tymelesstyre-frontend) — Vue.js + Vite client application


## Team

| Role | GitHub |
|------|--------|
| Project Lead | [@Siphokuhle-222357614](https://github.com/Siphokuhle-222357614) |
| Developer | [@222582731](https://github.com/222582731) |
| Developer | [@BonkeBulana](https://github.com/BonkeBulana) |
| Developer | [@Ofentselebaka](https://github.com/Ofentselebaka) |
| Developer | [@phelomadubela](https://github.com/phelomadubela) |
