# Sistema-Emprego

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
