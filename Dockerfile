# Stage 1: Build the app
FROM gradle:8.5-jdk17 AS builder
WORKDIR /app
COPY . .
RUN gradle build -x test

# Stage 2: Run the app
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar

# Optional: Document exposed port (Render doesn't use this directly)
EXPOSE 8080

# 🟢 This binds Spring Boot to Render's assigned port
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=${PORT}"]
