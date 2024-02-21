FROM openjdk:17-alpine

WORKDIR /app

COPY ./AlertGlideProvider .

RUN ./mvnw clean package -DskipTests
RUN mkdir ./logs
ENV PORT 8081
EXPOSE $PORT

ENTRYPOINT ["java", "-jar", "./target/AlertGlideProvider-0.0.1-SNAPSHOT.jar"]
