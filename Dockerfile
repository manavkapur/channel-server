# Use a lightweight Java 17 image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy all files
COPY . .

# Build the JAR (skip tests for faster deploy)
RUN ./mvnw clean package -DskipTests

# Expose the service port
EXPOSE 8083

# Run the service
ENTRYPOINT ["java", "-jar", "target/channel-server-0.0.1-SNAPSHOT.jar"]
