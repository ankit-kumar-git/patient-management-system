Patient Management System (Microservices)

A backend system built using **Java and Spring Boot**, following a **microservices architecture**.  
The project demonstrates real-world backend concepts including **API Gateway, authentication, event-driven communication using Kafka, and inter-service communication using gRPC**.

---

## 🚀 Tech Stack

- Java 21
- Spring Boot
- Spring Cloud Gateway
- Apache Kafka
- gRPC (Protocol Buffers)
- PostgreSQL
- Docker

---

## 📌 Key Features

- Microservices-based architecture
- API Gateway for centralized routing
- JWT-based authentication and authorization
- Kafka-based event-driven communication
- gRPC-based inter-service communication
- Integration testing for core services
- Dockerized services

---

## 🧩 Services Overview

### API Gateway
- Acts as the entry point for all client requests
- Routes requests to appropriate microservices

### Auth Service
- Handles user authentication
- Generates and validates JWT tokens

### Patient Service
- Core service handling patient-related operations
- Publishes events to Kafka
- Communicates with Billing Service using gRPC

### Billing Service
- Handles billing logic
- Exposes gRPC server

### Analytics Service
- Consumes Kafka events
- Processes analytics data

---

## ⚡ Communication Patterns

- **Synchronous communication**: gRPC (Patient Service → Billing Service)
- **Asynchronous communication**: Kafka (Patient Service → Analytics Services)

---

## 🔐 Authentication

- JWT-based authentication
- Token generated on login
- Token validated for protected APIs

---

## 🧪 Testing

Integration tests implemented for:
- Auth Service
- Patient Service

These tests validate API behavior and service interactions.

---

## 🐳 Running the Project

Each service is containerized using Docker.

Example:

```bash
docker build -t patient-service .
docker run -d -p 4000:4000 patient-service
