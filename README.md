# 🧑‍💼 Sistema de Gestão de Emprego

Aplicação Web Java Spring Boot

**License:** MIT
**Tecnologias:** Java • Spring Boot • HTML • CSS • JavaScript • PostgreSQL

---

## 📘 Descrição

O **Sistema de Gestão de Emprego** é uma aplicação web desenvolvida em **Java 25** com **Spring Boot**, criada para facilitar a interação entre candidatos, empresas e administradores em um ambiente centralizado.

A plataforma permite que **empresas publiquem vagas**, **candidatos se inscrevam** e que **administradores controlem toda a atividade**, garantindo segurança, escalabilidade e desempenho.

O sistema segue o padrão **MVC**, utiliza **JPA/Hibernate** para persistência, **Spring Security** para autenticação e autorização, e possui estrutura flexível para futuras extensões.

---

## 📑 Table of Contents

* 📘 Descrição
* ✨ Funcionalidades
* 💻 Tecnologias Utilizadas
* 🛠️ Instalação
* 🚀 Uso do Sistema
* 👨‍💻 Como Funciona
* 🗂️ Estrutura do Projeto
* 🔑 Autenticação e Segurança
* 🤝 Contribuição
* 📄 Licença
* 🔗 Links Importantes
* 📝 Rodapé

---

## ✨ Funcionalidades

### 👤 **Candidato**

* Criar conta e fazer login
* Atualizar perfil (habilidades, contatos, upload de CV)
* Pesquisar e filtrar vagas
* Enviar candidatura
* Consultar estado das aplicações

### 🏢 **Empresa**

* Registrar e fazer login como empresa
* Criar, editar e remover vagas
* Acompanhar candidatos inscritos
* Filtrar candidatos por habilidades, experiência e formação
* Dashboard com métricas de vagas publicadas

### 🛡️ **Administrador**

* Gerenciar usuários (empresas e candidatos)
* Visualizar métricas gerais
* Acessar logs e auditorias
* Exportar relatórios
* Monitorar candidaturas

### ⚙️ **Funcionalidades Gerais**

* Arquitetura MVC
* CRUD completo para todas as entidades
* PostgreSQL
* Login com Spring Security
* Layout responsivo
* Tema claro/escuro
* Internacionalização (pt / en)
* Logger e auditoria automática

---

## 💻 Tech Stack

| Categoria   | Tecnologias                         |
| ----------- | ----------------------------------- |
| Linguagem   | Java 25                             |
| Backend     | Spring Boot 3.5.x                   |
| Segurança   | Spring Security + PasswordEncoder   |
| Front-End   | HTML • CSS • JavaScript • Thymeleaf |
| Banco       | PostgreSQL                          |
| Ferramentas | Maven, DevTools, Lombok, AOP        |

---

## 🛠️ Instalação

### ✔️ **Pré-requisitos**

* Java 17+ (25 recomendado)
* Maven
* PostgreSQL instalado e a correr

### ✔️ **Clonar o Repositório**

```bash
git clone https://github.com/SManhica/Sistema-Emprego.git
cd Sistema-Emprego
```

### ✔️ **Configurar o Banco de Dados**

Criar o banco no PostgreSQL e configurar:

```
src/main/resources/application.properties
```

```
spring.datasource.url=jdbc:postgresql://localhost:5432/nome_banco
spring.datasource.username=postgres
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
```

⚠️ Se a porta não for 5432, altere na URL.

---

## 🚀 Como Rodar o Sistema

```bash
mvn clean install
mvn spring-boot:run
```

A aplicação ficará disponível em:
👉 **[http://localhost:8080](http://localhost:8081)**

---

## 🚀 Uso do Sistema

### 👤 **Fluxo do Candidato**

1. Registro
2. Login
3. Completar perfil
4. Procurar vagas
5. Enviar candidatura
6. Acompanhar status

### 🏢 **Fluxo da Empresa**

1. Registro como empresa
2. Login
3. Publicar vagas
4. Analisar candidatos
5. Gerir candidaturas
6. Estatísticas

### 🛡️ **Fluxo do Administrador**

1. Acessar dashboard
2. Monitorar métricas
3. Consultar logs
4. Exportar relatórios
5. Gerenciar usuários

---

## 👨‍💻 Como Funciona

O sistema foi criado para simular um portal de emprego real, com:

* **Candidato** buscando oportunidades
* **Empresa** publicando vagas
* **Admin** supervisionando tudo

Usos possíveis:

* Portais de emprego
* Sistemas de estágio
* Plataformas de recrutamento
* Career centers

---

## 🗂️ Estrutura do Projeto

```
sistema-emprego/
│
├── src/main/java/com/seu_grupo/sistemaemprego/
│   ├── controller/
│   ├── model/
│   │   ├── entity/
│   │   ├── repository/
│   │   └── service/
│   ├── config/
│   └── SistemaEmpregoApplication.java
│
├── src/main/resources/
│   ├── templates/
│   │   ├── admin/
│   │   ├── empresa/
│   │   └── candidato/
│   ├── static/
│   │   ├── css/
│   │   └── js/
│   └── application.properties
│
├── pom.xml
└── README.md
```

---

## 🔑 Autenticação e Segurança

* PasswordEncoder para hashear senhas
* Autorização baseada em papéis:

  * ROLE_ADMIN
  * ROLE_EMPRESA
  * ROLE_CANDIDATO
* Sessões controladas
* Login / Logout
* CSRF configurável
* Rotas protegidas

---

## 🤝 Contribuição

1. Fazer **Fork**
2. Criar uma *feature branch*
3. Fazer **Commit**
4. Fazer **Push**
5. Abrir **Pull Request**

---

## 📄 Licença

Licença sugerida: **MIT**

---

## 🔗 Links Importantes

Repositório Original:
https://github.com/SManhica/Sistema-Emprego

---

## 📝 Rodapé

**Sistema de Gestão de Emprego – Engenharia Informática (2025)**
Autor do Projecto:
1.Alfaica, Keen Anastácio								
2.Cossa, Fenias Augusto
3.Caravela, Rosário Pompilio 
4.Manhiça, Shelton Felisberto
5.António, Saiforahaman
6.Valente, Wichard Valério

⭐ Se gostou, deixe uma estrela!
🍴 Contribua com um fork!
🐞 Relate problemas na aba Issues

> ⚠️ Se a porta for alterada no `application.properties`
> Usar: `http://localhost:PORTA_AQUI`
