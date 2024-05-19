# JwtTokenService

JwtTokenService is a Spring Boot application that demonstrates how to create, validate, and parse JSON Web Tokens (JWT) for authentication purposes. This project includes endpoints for user login, JWT generation, and token validation.

## Requirements

- Java 17
- Maven

## Setup

1. **Clone the repository:**

    ```bash
    git clone https://github.com/yourusername/JwtTokenService.git
    cd JwtTokenService
    ```

2. **Build the project:**

    ```bash
    mvn clean install
    ```

3. **Run the application:**

    ```bash
    mvn spring-boot:run
    ```

## Usage

### Generate Token

To generate a JWT, send a POST request to the `/login` endpoint with the user's credentials.

```bash
curl -X POST http://localhost:8080/login -H "Content-Type: application/json" -d '{"username": "yourUsername", "password": "yourPassword"}'
  ```




## Dependencies
### The project uses the following dependencies:

- **Spring Boot Starter Web:** For building web applications.
- **Spring Boot Starter Security:** For adding security features.
- **JSON Web Token (JWT):** For handling JWT creation and parsing.
- **Lombok:** To reduce boilerplate code.
- **JAXB:** To resolve issues with javax.xml.bind.DatatypeConverter.


See the `pom.xml` file for the full list of dependencies.