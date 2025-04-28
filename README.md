# Demo GraphQL Project

A demo Spring Boot application showcasing GraphQL API implementation for managing promotion resources.

## Technologies

- Java 21
- Spring Boot 3.4.1
- Spring Data JPA
- Spring GraphQL
- MySQL Database
- Liquibase for database migrations

## Project Structure

The project follows a standard package structure:

- `configuration`: Application configuration classes
- `dto`: Data Transfer Objects (request/response)
- `entity`: JPA entities
- `exception`: Custom exceptions and error handling
- `repository`: Spring Data JPA repositories
- `resolver`: GraphQL resolvers
- `service`: Business logic implementations

## Setup Instructions

1. Clone the repository
2. Copy `.env.example` to `.env` and configure your environment variables
3. Run the application with Maven: `./mvnw spring-boot:run`

## GraphQL API

The GraphQL API is available at `http://localhost:8080/graphql` and provides the following operations:

### Queries

- `getAll`: Retrieve all promotions
- `getById(id: ID!)`: Retrieve a specific promotion by ID

### Mutations

- `create(request: PromotionRequest!)`: Create a new promotion
- `update(id: ID!, request: PromotionRequest!)`: Update an existing promotion
- `delete(id: ID!)`: Delete a promotion

## Example Queries

### Get All Promotions

```graphql
query {
  getAll {
    id
    code
    description
    expiredDate
    discountPercent
  }
}
```

### Get Promotion by ID

```graphql
query {
  getById(id: "your-promotion-id") {
    id
    code
    description
    expiredDate
    discountPercent
    archivedMiles
    plusMiles
    quantity
  }
}
```

### Create Promotion

```graphql
mutation {
  create(request: {
    code: "SUMMER2025",
    description: "Summer Promotion 2025",
    expiredDate: "2025-09-30T23:59:59Z",
    discountPercent: 20,
    archivedMiles: 1000,
    plusMiles: 500,
    quantity: 100
  }) {
    id
    code
    expiredDate
  }
}
```