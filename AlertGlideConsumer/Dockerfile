FROM maven:3.8.1-jdk-17 AS build


WORKDIR /app

COPY ./AlertGlideConsumer .

RUN ./mvnw clean package -DskipTests

ENV PORT 5151
EXPOSE $PORT

RUN mkdir ./logs

ENTRYPOINT ["java", "-jar", "./target/AlertGlideConsumer-0.0.1-SNAPSHOT.jar"]

