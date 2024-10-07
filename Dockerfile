ARG DB_USERNAME
ARG DB_PASSWORD
ARG DB_URL

ENV DB_USERNAME=${DB_USERNAME}
ENV DB_PASSWORD=${DB_PASSWORD}
ENV DB_URL=${DB_URL}

# Use Maven image to build the application
FROM maven:latest

# Set working directory inside the container
WORKDIR /app

# Copy the pom.xml to download dependencies first (caching optimization)
COPY pom.xml /app/

# Copy the entire project to the container
COPY . /app/

# Package the application using Maven
RUN mvn clean package -DskipTests

# Run the main class from the built JAR
CMD ["java", "-jar", "target/CarRentalWeb.jar"]