FROM maven:3.8.1-jdk-17 AS build


WORKDIR /app

COPY ./AlertGlideProvider .

RUN ./mvnw clean package -DskipTests
RUN mkdir ./logs
ENV PORT 8081
EXPOSE $PORT

ENTRYPOINT ["java", "-jar", "./target/AlertGlideProvider-0.0.1-SNAPSHOT.jar"]
