# 🛒 BuyBuddy – E-Commerce Platform (Microservices)

**BuyBuddy** is a personal backend project that demonstrates the design and implementation of a **microservices-based e-commerce platform** using **Spring Boot** and **MySQL**. The system manages customers, products, and orders with proper service-to-service communication and service discovery.

---

## 🚀 Project Overview

BuyBuddy is built to simulate core functionalities of a real-world e-commerce system. It enables:

- Managing customers, products, and orders
- Handling relationships between entities (customers, orders, products)
- Inter-service communication using declarative REST clients
- Service discovery using a centralized registry

The project focuses on **backend architecture, microservices communication, and data consistency** rather than UI.

---

## 🏗️ Architecture Overview

The application follows a **microservices architecture**:

- **Customer Service** – Manages customer information
- **Product Service** – Manages product catalog and inventory
- **Order Service** – Handles order creation and order-product mapping
- **Service Registry** – Netflix Eureka Server for service discovery

Each service is independently deployable and communicates with others using **Spring Cloud OpenFeign**.

---

## 🔗 Entity Relationships

- A **Customer** can place **multiple Orders** (One-to-Many)
- An **Order** can contain **multiple Products**
- A **Product** can be part of **multiple Orders** (Many-to-Many)

These relationships are handled through proper database mappings and service coordination.

---

## 🛠️ Tech Stack

- **Language:** Java
- **Framework:** Spring Boot
- **Database:** MySQL
- **Architecture:** Microservices
- **Service Discovery:** Netflix Eureka Server
- **Inter-Service Communication:** Spring Cloud OpenFeign
- **ORM:** Spring Data JPA
- **Build Tool:** Gradle

---

## 📦 Core Features

### 👤 Customer Management
- Create, update, retrieve, and delete customers
- Fetch customer details along with order history

### 📦 Product Management
- Manage product catalog and inventory
- Create, update, and retrieve product details

### 🧾 Order Management
- Place orders for customers
- Associate multiple products with a single order
- Track order transactions

---

## 📡 API Capabilities

- RESTful APIs for Customer, Product, and Order services
- CRUD operations for all core entities
- Feign clients for seamless service-to-service calls
- Centralized service discovery using Eureka

---

## ⚙️ Service Discovery & Communication

- **Netflix Eureka Server** acts as the service registry
- All microservices register themselves with Eureka
- **OpenFeign** enables declarative REST calls between services
- Eliminates hardcoded service URLs and improves scalability

---

## 📁 High-Level Project Structure

```
buybuddy-parent
├── eureka-server
├── customer-service
├── product-service
└──order-service 
```

---

## 🧪 Testing

- Manual API testing using Postman
- Validation of inter-service communication via Feign clients

---

## 🎯 Learning Outcomes

- Understanding microservices-based system design
- Implementing service registry and discovery
- Using OpenFeign for inter-service communication
- Managing relational data across services
- Designing scalable backend systems using Spring Boot

---

## 👤 Author

**Prathamesh Kumbhar**  
Java Backend Developer

---

## ⭐ Final Notes

BuyBuddy was developed as a **personal learning project** to gain hands-on experience with **Spring Boot microservices**, service discovery, and distributed system communication. It reflects practical backend design concepts commonly used in real-world e-commerce platforms.

Feel free to ⭐ star the repository or explore the code!

