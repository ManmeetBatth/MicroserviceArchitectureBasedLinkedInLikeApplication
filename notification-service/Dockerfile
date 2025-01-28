# Use Maven with Eclipse Temurin JDK 21 as the base image
FROM maven:3.9.4-eclipse-temurin-21-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy Maven wrapper files and the Maven configuration file
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Pre-download dependencies to reduce build time
RUN ./mvnw dependency:go-offline

# Copy the source code into the container
COPY src ./src

# Run the Spring Boot application when the container starts
CMD ["./mvnw", "spring-boot:run"]
