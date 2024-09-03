#FROM openjdk:17
#MAINTAINER Jesus Plasencia <jesusplasencia2508@hotmail.com>
#WORKDIR /app
#COPY .mvn/ .mvn
#COPY mvnw pom.xml ./
#RUN ./mvnw dependency:go-offline
#COPY src ./src
#CMD ["./mvnw", "spring-boot:run"]

# Step 1: Build the application
#FROM maven:3.8.6-eclipse-temurin-17 AS build
#WORKDIR /app
#COPY pom.xml .
#COPY src ./src
#RUN mvn clean package -DskipTests
#
## Step 2: Create the final image
#FROM eclipse-temurin:17-jdk-jammy
#WORKDIR /app
#COPY --from=build /app/target/*.jar app.jar
#
## Run the application
#ENTRYPOINT ["java","-jar","app.jar"]

FROM eclipse-temurin:17-jdk-jammy as builder
WORKDIR /opt/app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install

FROM eclipse-temurin:17-jre-jammy
WORKDIR /opt/app
EXPOSE 8080
COPY --from=builder /opt/app/target/*.jar /opt/app/*.jar
ENTRYPOINT ["java", "-jar", "/opt/app/*.jar"]
