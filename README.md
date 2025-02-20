<h2 id="started">📌 Sobre</h2>
Este é um sistema de agendamento de transferências financeiras desenvolvido com Spring Boot.


![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)
![Mockito](https://img.shields.io/badge/mockito-%230076.svg?style=for-the-badge&logo=mockito&logoColor=white)
![Angular](https://img.shields.io/badge/angular-%23DD0031.svg?style=for-the-badge&logo=angular&logoColor=white)


## Tecnologias Utilizadas
- **Java 11**
- **Spring Boot 2.7.0**
- **Maven 3.9.9**
- **Angular 19.1.7**

## Como Executar o Projeto Localmente


### Backend (API)
1. Clone o repositório

2. Compile e execute o projeto:

    ```sh
   mvn clean install
   ```
    ```sh
   mvn spring-boot:run
   ```
3. A API estará disponível em `http://localhost:8080`

### Frontend (Angular)
1. Acesse a pasta do projeto frontend:
   ```sh
   cd tokioMarine-Front
   ```
2. Instale as dependências:
   ```sh
   npm install
   ```
3. Execute a aplicação:
   ```sh
   ng serve --proxy-config proxy.conf.json
   ```
4. O frontend estará disponível em `http://localhost:4200`

## Endpoints Disponíveis


**Endpoint:** `POST localhost:8080/authentication/register`
- Descrição: Permite cadastrar uma conta.
{
  "name": "gabriel silva ",
  "cpf": "4887864003",
  "password": "147A5B4A7g"
}
**Endpoint:** `POST localhost:8080/authentication/login`
- Descrição: Permite realizar o login.
{
  "cpf": "4887864003",
  "password": "147A5B4A7g"
}
gera o BearToken

### 1. Cadastrar Taxas

**Endpoint:** `POST /taxas/cadastrar`

- Descrição: Permite cadastrar taxas para transferências.
- Exemplo de Request Body:
  ```json
  {
    "max_days": 10,
    "min_days": 1,
    "taxa": 5,
    "valor": 1000
  }
  ```

### 2. Realizar Transferência
**Endpoint:** `POST /transferencia`

- Descrição: Realiza o agendamento de uma transferência financeira.
- Exemplo de Request Body:
  ```json
  {
    "conta_destino": "A987654321",
    "conta_origem": 1234567890,
    "data_Agendamento": "20/02/2025",
    "originAccount": "string",
    "valor": 1500
  }
  ```

### 3. Listar Transferências por Conta
**Endpoint:** `GET /transferencia/listar/{account}`

- Descrição: Retorna todas as transferências associadas a uma conta.
- Exemplo de Uso:
  ```sh
  curl -X GET http://localhost:8080/transferencia/listar/0123456789
  ```

## Documentação da API (Swagger)
Para acessar a documentação interativa via Swagger, utilize:
- [Swagger UI](http://localhost:8080/swagger-ui/#/transfer-controller/listTransfersUsingGET)

