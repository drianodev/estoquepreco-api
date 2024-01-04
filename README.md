**README - Estoque / Preco - API**

Este repositório contém um projeto Spring Boot chamado "estoquepreco-api", demonstrando a integração de mensagens RabbitMQ com um sistema simples de inventário e preços. O projeto permite a atualização de informações de inventário e preços por meio de endpoints REST, com as alterações comunicadas via RabbitMQ.

## Estrutura do Projeto

A estrutura do projeto é a seguinte:

- **`src/main/java/br/com/drianodev/estoquepreco/`**: Diretório de código-fonte Java.
  - **`EstoqueprecoApplication.java`**: Classe principal da aplicação.
  - **`conections/RabbitMQConection.java`**: Classe de conexão e configuração RabbitMQ.
  - **`controllers/`**: Controladores REST para manipular atualizações de inventário e preços.
  - **`dtos/`**: Objetos de Transferência de Dados para inventário (`EstoqueDTO`) e preços (`PrecoDTO`).
  - **`RabbitMQConstants.java`**: Arquivo de constantes para nomes de filas RabbitMQ.

- **`src/main/resources/`**: Diretório de recursos.
  - **`application.properties`**: Propriedades de configuração, incluindo detalhes de conexão RabbitMQ.

- **`pom.xml`**: Arquivo Maven Project Object Model.

## Pré-requisitos

Certifique-se de ter instalado:

- Java 17
- Maven
- RabbitMQ

## Configuração e Execução

1. Clone o repositório:

   ```bash
   git clone https://github.com/your-username/estoquepreco.git
   cd estoquepreco
   ```

2. Compile o projeto:

   ```bash
   mvn clean install
   ```

3. Execute a aplicação:

   ```bash
   java -jar target/estoquepreco-0.0.1-SNAPSHOT.jar
   ```

   A aplicação será iniciada em `http://localhost:8080`.

## Configuração RabbitMQ

Certifique-se de que o RabbitMQ esteja em execução com a configuração padrão especificada em `application.properties`. Você pode modificar os detalhes de conexão do RabbitMQ neste arquivo, se necessário.

```properties
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=admin
spring.rabbitmq.password=123456
```

## Uso

O projeto fornece dois endpoints REST:

1. **Atualizar Inventário**:
   - Endpoint: `PUT /estoque`
   - Corpo da Requisição (JSON):
     ```json
     {
       "codigoProduto": "ABC123",
       "quantidade": 50
     }
     ```

2. **Atualizar Preço**:
   - Endpoint: `PUT /preco`
   - Corpo da Requisição (JSON):
     ```json
     {
       "codigoPreco": "PRC456",
       "preco": 29.99
     }
     ```

Certifique-se de que o servidor RabbitMQ esteja em execução para lidar com a comunicação entre esses endpoints.
