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


## 🐳 Running the Entire System (Docker Compose)

This project supports running all microservices using Docker Compose.

---

### 📌 Prerequisites

- Docker installed
- Docker Compose installed

---

### ⚙️ Step 1: Build all services

Run inside each service directory:

docker build -t auth-service .
docker build -t patient-service .
docker build -t billing-service .
docker build -t analytics-service .
docker build -t api-gateway .


### ▶️ Step 2: Start all services

docker-compose up -d

### ▶️ Step 3: Verify running containers

docker ps -a

You should see containers for:

api-gateway
auth-service
patient-service
billing-service
analytics-service
kafka
patient-service-db
auth-service-db

### Step 4: Stop and remove all container

docker-compose down

-----------------------------------------------------------------------
## 📄 API Documentation (Swagger / OpenAPI)

API documentation for services is available via the API Gateway.

---
### 🔹 Patient Service API Docs
http://localhost:4004/api-docs/patients
---
### 🔹 Auth Service API Docs
http://localhost:4004/api-docs/auth
---
### 🧠 Notes
- API docs are exposed through the **API Gateway**
- Underlying services expose `/v3/api-docs`
- Gateway rewrites paths for unified access