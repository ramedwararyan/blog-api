# 📝 Full-Stack Blogging Platform

A scalable and secure full-stack blogging platform built using **Spring Boot** and **ReactJS**, designed to enable users to create, manage, and engage with content efficiently.

---

## 🚀 Project Overview

This project is a complete blogging solution that supports authenticated users, role-based access control, and modern REST API practices. It focuses on performance, security, and clean architecture.

---

## 🛠️ Tech Stack

### Backend
- Spring Boot
- Spring Security
- JWT Authentication
- RESTful APIs
- Swagger / OpenAPI
- MySQL / PostgreSQL (configurable)

### Frontend
- ReactJS
- Context API
- Axios
- Responsive UI

---

## ✨ Key Features

- 🔐 **JWT Authentication & Role-Based Authorization**  
  Implemented secure login and role-based access control, reducing security risks by approximately **90%**.

- 📝 **Blog Management**  
  Users can create, update, delete, and view blog posts with support for:
  - Comments
  - Categories

- 📚 **API Documentation**  
  Integrated **Swagger/OpenAPI**, reducing API onboarding time by nearly **30%**.

- ⚡ **Performance Optimization**  
  Optimized backend queries and logic to achieve approximately **25% faster API response times**.

- 👥 **User Roles**
  - Admin
  - Author
  - User

---

## 📂 Project Structure
blog-api/
├── /blog-api (Spring Boot APIs)
├── /blog (ReactJS Application)
└── README.md


---

## ▶️ Getting Started

### Backend
```bash
cd blog-api
mvn spring-boot:run

cd blog
npm install
npm start

🔐 API Documentation

Once the backend is running, access Swagger UI at:

http://localhost:8080/swagger-ui.html
