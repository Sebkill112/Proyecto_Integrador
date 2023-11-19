FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests
RUN mvn clean package 

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/ProyectoIntegrador-0.0.1-SNAPSHOT.jar ProyectoIntegrador.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","ProyectoIntegrador.jar"]