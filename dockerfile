FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} sitas-luggage-managment-API-1.0.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/sitas-luggage-managment-API-1.0.jar"]