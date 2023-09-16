FROM openjdk:11-slim-buster

WORKDIR /app

ARG ORIGINAL_JAR_FILE=./build/libs/delivery-service-1.0.0.jar

COPY ${ORIGINAL_JAR_FILE} delivery-service.jar

CMD ["java", "-jar", "/app/delivery-service.jar"]
