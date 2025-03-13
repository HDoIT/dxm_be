#FROM ubuntu:latest
#LABEL authors="HP"
#VOLUME /tmp
#COPY target/*.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
##ENTRYPOINT ["top", "-b"]
# Stage 1: Build the JAR file
FROM maven:3.8.6-openjdk-8 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Create the final image
FROM openjdk:8-jdk-alpine
LABEL authors="HP"
WORKDIR /app
COPY --from=build /app/target/dxmbe-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9123
ENTRYPOINT ["java", "-jar", "app.jar"]