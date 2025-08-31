# 🚀 Job Finding Platform

Robust Spring Boot backend for managing job seekers, recruiters, applications, and admin workflows.Secured with JWT Authentication and integrated with Swagger UI.

---

## ✨ Features

🔑 JWT-secured REST API  
👤 User Roles – Jobseeker, Recruiter, Admin  
📂 Profile Management – including file uploads/resume  
📝 Job Applications – apply, track, and manage status  
🔒 Admin Workflows – block/unblock users, audit actions  
📧 Email Notifications – powered by Spring Mail  
📖 Interactive Documentation – via Swagger UI  

---

## 🛠️ Tech Stack

☕ Java 17+  
🌱 Spring Boot 3+, Spring Security, JWT  
🗄  Spring Data JPA (MySQL)  
📬 Spring Mail  
📑 Swagger (springdoc-openapi)
⚡ Maven,Lombok  

---

## 📝 Getting Started  

### Prerequisites

 Java 17+ 
 Maven 3.6+  
 MySQL running locally  
 Gmail App password (optional) 

### Installation
```bash
git clone https://github.com/gv-arc/zidio-job-connect.git
cd job-finding-platform
mvn clean install
```

### Configuration
```
spring.datasource.url=jdbc:mysql://localhost:3306/job_platform_db
spring.datasource.username=your-mysql-username
spring.datasource.password=your-mysql-password
spring.jpa.hibernate.ddl-auto=update

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-gmail@gmail.com
spring.mail.password=your-app-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

jwt.secret=your-jwt-secret
jwt.expiration=86400000

```

---
## ▶️ Running

mvn spring-boot:run

App runs on http://localhost:8080.

---

## 📚 API Docs
Interactive UI: http://localhost:8080/swagger-ui.html

Test endpoints, view schemas, use "Authorize" for JWT-protected APIs.

---
## 🧑‍💻 Usage

### API Endpoints

> (See Swagger for detailed request/response examples)

| Endpoint                      | Description                 | Auth |
|-------------------------------|-----------------------------|------|
| `/api/auth/register`          | Register user               | ❌   |
| `/api/auth/login`             | Login, get JWT              | ❌   |
| `/api/jobSeekers/me`          | Get/update profile          | ✅   |
| `/api/jobSeekers/me/resume`   | Upload resume               | ✅   |
| `/api/applications/apply`     | Apply for job               | ✅   |
| `/api/applications/jobSeeker` | View own applications       | ✅   |
| `/api/admins/action`          | Admin block/unblock user    | ✅   |
| `/api/notifications/send`     | Send email notification     | ✅   |

---

## Project Structure

```text
src
└── main
    ├── java
    │   └── com
    │       └── yourorg
    │           └── jobfindingplatform
    │               ├── config
    │               ├── controller
    │               ├── dto
    │               ├── entity
    │               ├── repository
    │               ├── security
    │               └── service
    └── resources
        └── application.properties
```

---

## 🧪 Testing
  ### Swagger UI: 
           Try endpoints in browser, paste JWT in "Authorize".

  ### Postman: 
           Login to get JWT, set header Authorization: Bearer <token>, test APIs.

--- 

## 🛠 Troubleshooting

  401 Unauthorized: JWT missing/invalid, use token from login

  Swagger UI not visible: Update security config to permit /swagger-ui.html, /v3/api-docs/**

  Email fails: Setup Gmail app password, check SMTP details

  DB errors: Check MySQL credentials, DB running

---
 
 ## 📄 License
    MIT

--- 

##  Contact

👨‍💻 **Backend Developers**  

- **Gaurav Singh**   
- **Sourabh** 