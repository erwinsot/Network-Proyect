FROM maven:3.8.4-openjdk-17-slim


WORKDIR /app

COPY ./AlertGlideProvider .

RUN mvn clean package -DskipTests
RUN mkdir ./logs
ENV PORT 8081
EXPOSE $PORT

ENTRYPOINT ["java", "-jar", "./target/AlertGlideProvider-0.0.1-SNAPSHOT.jar"]
