FROM maven:3.8.1-openjdk-11 AS build

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn package

FROM adoptopenjdk/openjdk11:alpine-jre

WORKDIR /app

ENV TZ=America/Sao_Paulo

COPY --from=build /app/target/*.jar .

RUN addgroup -g 1001 -S appuser \
    && adduser -u 1001 -S appuser -G appuser \
    && chown -R appuser:appuser /app

USER appuser

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "infracoes-api.jar"]

