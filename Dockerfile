# Build Stage
FROM maven:latest AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and download dependencies (cache layer)
COPY pom.xml /app/

# Copy the rest of the application code
COPY . /app/

# Package the application without running tests
RUN mvn clean package -X

# Runtime Stage (smaller image)
FROM openjdk:17-jdk-slim

# Set the working directory for the runtime container
WORKDIR /app

# Copy only the built JAR file from the build stage
COPY --from=build /app/target/CarRentalWeb.jar /app/CarRentalWeb.jar

# Expose the port your application is running on (adjust if necessary)
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "CarRentalWeb.jar"]
