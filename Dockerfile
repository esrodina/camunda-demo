FROM eclipse-temurin:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app-camunda.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app-camunda.jar"]