FROM maven:3.8.4-openjdk-17-slim AS build


WORKDIR /app

COPY ./AlertGlideConsumer .

RUN mvn clean package -DskipTests

ENV PORT 5151
EXPOSE $PORT

RUN mkdir ./logs

ENTRYPOINT ["java", "-jar", "./target/AlertGlideConsumer-0.0.1-SNAPSHOT.jar"]

