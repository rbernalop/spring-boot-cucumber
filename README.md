# Cucumber with Spring Boot 🥒

This project demonstrates how to integrate Cucumber with a Spring Boot application for behavior-driven development (BDD).

## Spring Boot Application 🍃

The application provides a RESTful service to create a new user. 
- The controller endpoint for creating a user is `POST api/v1/user`.
- Database prepared: H2.

## Running the Application 🏃

To run the Spring Boot application:
1. Build the project using Maven: `mvn clean install`.
2. Run the application: `mvn spring-boot:run`.
3. The application will start and be accessible on `http://localhost:8080`.

## Testing with Cucumber 🧪

- To execute the Cucumber tests with Maven: `mvn clean verify`.
- Tests definitions are located at: `src/test/resources/cucumber_tests`.
