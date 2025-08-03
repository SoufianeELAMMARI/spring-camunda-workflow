# Camunda Workflow Engine with Spring Boot

[![Camunda Version](https://img.shields.io/badge/Camunda-7.23.0-blue)](https://camunda.com)
[![Spring Boot Version](https://img.shields.io/badge/Spring%20Boot-3.4.4-brightgreen)](https://spring.io/projects/spring-boot)
[![Java Version](https://img.shields.io/badge/Java-17-orange)](https://openjdk.org/projects/jdk/17/)

## Table of Contents

## Features
- **Camunda Integration**:
    - Full BPMN 2.0 workflow engine
    - REST API and Web Apps (Tasklist, Cockpit, Admin)
    - SPIN data format support (JSON/XML)
- **Spring Boot**:
    - Auto-configured Camunda engine
    - Spring Data JPA support
    - Embedded web server
- **Database**:
    - H2 in-memory database (default)
    - Easy to switch to MySQL/PostgreSQL
- **API Documentation**:
    - OpenAPI 3.0 specification
    - Interactive Swagger UI

## Prerequisites
- JDK 17+
- Maven 3.6+
- (Optional) Docker for containerized deployment


# Camunda Task Engine API Guide

## Task API Endpoints

### 1. Fetch Tasks
```http
GET /engine-rest/task
curl -X GET "http://localhost:8080/engine-rest/task"
2. Get Specific Task
http
GET /engine-rest/task/{id}
bash
curl -X GET "http://localhost:8080/engine-rest/task/aTaskId"
3. Claim Task
http
POST /engine-rest/task/{id}/claim
bash
curl -X POST "http://localhost:8080/engine-rest/task/aTaskId/claim" \
     -H "Content-Type: application/json" \
     -d '{"userId": "demo"}'
4. Complete Task
http
POST /engine-rest/task/{id}/complete
bash
curl -X POST "http://localhost:8080/engine-rest/task/aTaskId/complete" \
     -H "Content-Type: application/json" \
     -d '{"variables": {"approved": {"value": true}}}'
5. Get Task Variables
http
GET /engine-rest/task/{id}/variables
bash
curl -X GET "http://localhost:8080/engine-rest/task/aTaskId/variables"
Task Filtering
1. Filter by Assignee
bash
curl -X GET "http://localhost:8080/engine-rest/task?assignee=demo"
2. Filter by Process Instance
bash
curl -X GET "http://localhost:8080/engine-rest/task?processInstanceId=123"
3. Filter Unassigned Tasks
bash
curl -X GET "http://localhost:8080/engine-rest/task?unassigned=true"
Complete Test Flow
Start process:

bash
curl -X POST "http://localhost:8080/engine-rest/process-definition/key/invoice/start" \
     -H "Content-Type: application/json" \
     -d '{"variables": {"amount": {"value": 1000}}}'
List tasks:

bash
curl -X GET "http://localhost:8080/engine-rest/task"
Claim and complete:

bash
curl -X POST "http://localhost:8080/engine-rest/task/aTaskId/claim" \
     -d '{"userId": "demo"}'

curl -X POST "http://localhost:8080/engine-rest/task/aTaskId/complete" \
     -d '{"variables": {"approved": {"value": true}}}'
Authentication
bash
curl -H "Authorization: Basic $(echo -n 'camunda:camunda' | base64)" \
     -X GET "http://localhost:8080/engine-rest/task"
Note: Replace aTaskId, invoice, and other placeholders with your actual values

Swagger UI: Available at http://localhost:8080/swagger-ui.html

text

   