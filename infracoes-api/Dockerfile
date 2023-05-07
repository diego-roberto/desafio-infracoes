FROM openjdk:11-jdk-slim

RUN apt update && apt upgrade -y && apt install dos2unix && \
    apt remove --auto-remove python -y && apt-get purge python -y && \
    apt-get update

COPY . .
RUN dos2unix ./mvnw
RUN chmod +x ./mvnw
RUN ./mvnw -s settings.xml clean package -DskipTests=true

#FROM adoptopenjdk/openjdk11:alpine-jre
#WORKDIR /app
#ENV TZ=America/Sao_Paulo
#COPY --from=build /build/target/*.jar .
#RUN addgroup -g 1001 -S appuser \
#    && adduser -u 1001 -S appuser -G appuser \
#    && chown -R appuser:appuser /app
#
#USER appuser
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "infracoes-api.jar"]
