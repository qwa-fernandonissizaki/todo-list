FROM openjdk:11-jdk-slim-buster

WORKDIR /app

COPY target/app.jar /app/application.jar

CMD ["java", "-jar", "/app/application.jar"]

