# Use a lightweight OpenJDK image as the base image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the jar file from your build to the container
COPY build/libs/srp-backend-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app runs on (default 8080)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
