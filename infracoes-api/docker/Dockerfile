FROM openjdk:11-jdk-slim

RUN apt update && apt upgrade -y && apt install dos2unix && \
    apt remove --auto-remove python -y && apt-get purge python -y && \
    apt-get update

COPY . .
RUN dos2unix ./mvnw
RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests=true

#FROM adoptopenjdk/openjdk11:alpine-jre
#WORKDIR /app
#ENV TZ=America/Sao_Paulo
#COPY --from=build /target/*.jar /app/
#RUN addgroup -g 1001 -S appuser \
#    && adduser -u 1001 -S appuser -G appuser \
#    && chown -R appuser:appuser /app
#
#USER appuser
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "infracoes-api.jar"]

FROM openjdk:11-jdk-slim
RUN apt update && apt upgrade -y && apt install -y locales && \
    apt remove --auto-remove python -y && apt-get purge python -y && \
    apt-get update
ENV TZ=America/Sao_Paulo
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY --from=0 /target/*.jar  /infracoes-api.jar

EXPOSE 8080
CMD ["java", "-Xms256m", "-Xmx768m", "-jar", "/infracoes-api.jar"]
