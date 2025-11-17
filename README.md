🧑‍💼 Sistema de Gestão de Emprego – Aplicação Web Java Spring Boot

License: MIT (ou outra que escolher)
Technologies: Java • Spring Boot • HTML • CSS • JavaScript • PostgreSQL

📘 Description

The Employment Management System is a web platform developed in Java 25 with Spring Boot, designed to manage job vacancies, candidates, applications, and company accounts.
It provides a complete environment where companies can publish vacancies, candidates can apply, and administrators can monitor system activity.

The project follows the MVC pattern, uses JPA for persistence, Spring Security for authentication, and employs dynamic data structures to ensure scalability and performance.

📑 Table of Contents

📘 Description

✨ Features

💻 Tech Stack

🛠️ Installation

🚀 Usage

👨‍💻 How to Use

🗂️ Project Structure

🔑 Authentication and Security

🤝 Contributing

📄 License

🔗 Important Links

📝 Footer

✨ Features
👤 Candidate Features

Create an account and login

Edit profile (skills, CV upload, contacts)

Search and filter job vacancies

Apply for vacancies

View application status

🏢 Company Features

Company registration and login

Publish, edit, and remove job vacancies

View list of candidates

Filter applicants by skills, experience, and education

Dashboard with job statistics

🛡️ Admin Features

Manage all users (companies & candidates)

System metrics dashboard

Logs/auditing of important actions

View activity reports

⚙️ General Features

MVC architecture

PostgreSQL database

CRUD operations for core entities

Spring Security with PasswordEncoder

Responsive frontend

Light/Dark mode

Internationalization (pt/en)

💻 Tech Stack

Language: Java 25

Framework: Spring Boot 3.5.x

Template Engine: Thymeleaf

Database: PostgreSQL

Build Tool: Maven

Security: Spring Security

Frontend: HTML, CSS, JS

Other: Lombok, Validation, AOP, DevTools

🛠️ Installation
Prerequisites

Java 25

Maven

PostgreSQL

Clone the Repository
git clone https://github.com/seuusuario/seu-repositorio.git
cd seu-repositorio

Configure the Database

Create a PostgreSQL database and update:

spring.datasource.url=jdbc:postgresql://localhost:5432/emprego_db
spring.datasource.username=your_user
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

Build the Application
mvn clean install

Run the Application
mvn spring-boot:run

🚀 Usage
Access the Application

Open:

http://localhost:8080

Candidate Workflow

Register and log in

Complete profile

Find jobs

Submit applications

Company Workflow

Register as company

Publish job vacancies

View candidates

Manage applications

Admin Workflow

Access admin dashboard

Monitor system metrics

Export reports

View logs

👨‍💻 How to Use
Real Use Cases

Job portals

Internship management systems

HR recruitment tools

School & university career portals

Basic Steps

Sign Up (Candidate/Company/Admin)

Login using Spring Security

Dashboard Redirect

CRUD management

Export reports, view logs

🗂️ Project Structure
sistema-emprego/
│
├── src/main/java/com/seu_grupo/sistemaemprego/
│   ├── controller/          # Spring MVC Controllers
│   ├── model/
│   │   ├── entity/          # Entities: Usuario, Empresa, Candidato, Vaga, Candidatura, Admin
│   │   ├── repository/      # JPA Repositories
│   │   └── service/         # Business Logic
│   ├── config/              # SecurityConfig, MailConfig, etc.
│   └── SistemaEmpregoApplication.java
│
├── src/main/resources/
│   ├── templates/           # Thymeleaf templates
│   │   ├── admin/
│   │   ├── empresa/
│   │   └── candidato/
│   ├── static/
│   │   ├── css/
│   │   └── js/
│   └── application.properties
│
├── pom.xml                  # Maven config
└── README.md

🔑 Authentication and Security

SecurityConfig includes:

PasswordEncoder

Login and logout configuration

Role-based access (ADMIN, EMPRESA, CANDIDATO)

Session management

CSRF options

🤝 Contributing

Fork the repository

Create a feature branch

Commit changes

Push and submit a pull request

📄 License

MIT License (or the one you choose)

🔗 Important Links

Seu GitHub: https://github.com/RosarioCaravela

📝 Footer

Repository Name: sistema-emprego
Author: Rosário Caravela
If you find this project helpful:

⭐ Give it a star

🍴 Fork it

🐞 Report issues

## Requisitos

* Java 17+
* Maven
* PostgreSQL instalado e a correr

---

## Clonar o Projeto

```sh
git clone https://github.com/SManhica/Sistema-Emprego.git
cd Sistema-Emprego
```

---

## Configuração do Banco

1. Criar a base de dados
2. Restaurar o backup (arquivo `.sql` ou `.backup`)
3. Editar o arquivo:

`src/main/resources/application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nome_banco
spring.datasource.username=postgres
spring.datasource.password=SUA_SENHA
```

> ⚠️ A porta do banco pode ser diferente:
> Se não for 5432, alterar na `url`

---

## Como Rodar

```sh
mvn clean install
mvn spring-boot:run
```

Por padrão, a app inicia em:

👉 [http://localhost:8080](http://localhost:8081)

> ⚠️ Se a porta for alterada no `application.properties`
> Usar: `http://localhost:PORTA_AQUI`
