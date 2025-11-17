🧑‍💼 Sistema de Gestão de Emprego

Aplicação Web Java Spring Boot

License: MIT
Tecnologias: Java • Spring Boot • HTML • CSS • JavaScript • PostgreSQL

📘 Descrição

O Sistema de Gestão de Emprego é uma aplicação web desenvolvida em Java 25 com Spring Boot, criada para facilitar a interação entre candidatos, empresas e administradores em um ambiente unificado.

A plataforma permite que empresas publiquem vagas, candidatos se inscrevam e que administradores controlem toda a atividade do sistema, garantindo segurança, escalabilidade e performance.

O sistema segue rigorosamente o padrão MVC, utiliza JPA/Hibernate para persistência de dados, Spring Security para autenticação e autorização, além de estruturas dinâmicas para garantir flexibilidade e extensões futuras.

📑 Table of Contents

📘 Descrição

✨ Funcionalidades

💻 Tecnologias Utilizadas

🛠️ Instalação

🚀 Uso do Sistema

👨‍💻 Como Funciona

🗂️ Estrutura do Projeto

🔑 Autenticação e Segurança

🤝 Contribuição

📄 Licença

🔗 Links Importantes

📝 Rodapé

✨ Funcionalidades
👤 Candidato

Criar conta e fazer login

Atualizar perfil (habilidades, contatos, CV upload)

Pesquisar e filtrar vagas

Enviar candidatura

Consultar o estado das aplicações

🏢 Empresa

Registrar e fazer login como empresa

Criar, editar e remover vagas

Acompanhar candidatos inscritos

Filtrar candidatos por:

Habilidades

Experiência

Formação

Dashboard de métricas de vagas publicadas

🛡️ Administrador

Gerenciar usuários (empresas e candidatos)

Visualizar métricas gerais do sistema

Acessar logs e auditorias

Exportar relatórios de atividades

Monitorar candidaturas

⚙️ Funcionalidades Gerais

Arquitetura MVC

CRUD completo para todas as entidades

Banco de dados PostgreSQL

Sistema de login com Spring Security

Layout responsivo

Tema Claro/Escuro

Internacionalização (pt / en)

Logger e auditoria automática

💻 Tech Stack
Categoria	Tecnologias
Linguagem	Java 25
Framework Backend	Spring Boot 3.5.x
Segurança	Spring Security + PasswordEncoder
Front-End	HTML • CSS • JavaScript • Thymeleaf
Banco de Dados	PostgreSQL
Ferramentas	Maven, DevTools, Lombok, AOP
🛠️ Instalação
✔️ Pré-Requisitos

Java 17+ (ou 25 recomendado)

Maven

PostgreSQL instalado e a correr

✔️ Clonar o Repositório
git clone https://github.com/SManhica/Sistema-Emprego.git
cd Sistema-Emprego

✔️ Configurar o Banco de Dados

Criar o banco no PostgreSQL

Restaurar o backup .sql ou .backup caso exista

Editar o arquivo:

src/main/resources/application.properties

spring.datasource.url=jdbc:postgresql://localhost:5432/nome_banco
spring.datasource.username=postgres
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update


⚠️ Atenção à porta do PostgreSQL
Se não for 5432, alterar na url.

🚀 Como Rodar o Sistema
mvn clean install
mvn spring-boot:run


Por padrão estará disponível em:

👉 http://localhost:8080

🚀 Uso do Sistema
👤 Fluxo do Candidato

Registro

Login

Completar perfil

Procurar vagas

Enviar candidatura

Acompanhar status

🏢 Fluxo da Empresa

Registro como empresa

Login

Publicar vagas

Analisar candidatos

Gerir candidaturas

Acessar estatísticas

🛡️ Fluxo do Administrador

Acessar dashboard

Monitorar métricas

Consultar logs

Exportar relatórios

Gerenciar usuários

👨‍💻 Como Funciona

O sistema foi desenvolvido para simular um portal de emprego real, com separação clara de responsabilidades:

Candidato: busca oportunidades

Empresa: publica oportunidades

Admin: supervisiona toda a operação

Utilidades práticas:

Portais de emprego

Sistemas de estágio

Plataformas de recrutamento

Career Centers de universidades

🗂️ Estrutura do Projeto
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

🔑 Autenticação e Segurança

Configurações incluídas:

PasswordEncoder para hashear senhas

Autorização baseada em papéis:

ROLE_ADMIN

ROLE_EMPRESA

ROLE_CANDIDATO

Sessões controladas

Login / Logout

CSRF configurável

Rotas protegidas

🤝 Contribuição

Fork

Criar feature branch

Commit

Push

Abrir Pull Request

📄 Licença

Licença sugerida: MIT
(O Open Source mais comum e permissivo)

🔗 Links Importantes

GitHub Rosário:
https://github.com/RosarioCaravela

📝 Rodapé

Sistema de Gestão de Emprego – Engenharia Informática (2025)
Autor: Rosário Caravela

⭐ Se gostou do projeto, deixe uma star
🍴 Contribua com um fork
🐞 Sinalize problemas na aba Issues
> ⚠️ Se a porta for alterada no `application.properties`
> Usar: `http://localhost:PORTA_AQUI`
