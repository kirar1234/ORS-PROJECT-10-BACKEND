# Use an official OpenJDK runtime as the base image
FROM eclipse-temurin:11-jdk

# Set the working directory to /app
WORKDIR /app

# Copy the Spring Boot application JAR file into the container
COPY ./target/ORSProject-10-0.0.1-SNAPSHOT.jar /app/ORSProject-10-0.0.1-SNAPSHOT.jar

# Expose port 8080 for the application
EXPOSE 8080

# Define the command to run the Spring Boot application
CMD ["java", "-jar", "ORSProject-10-0.0.1-SNAPSHOT.jar"]