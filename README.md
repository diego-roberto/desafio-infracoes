# Desafio API de Infrações
Projeto consiste em uma API REST para Infrações, um Serviço simulador de infrações que envia infrações aleatórias a cada 3 segundos para a API e um Front-end para visualização das infrações da base.
</br>

<h3>
<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/>
<img src="https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot"/>
<img src="https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white"/>
<img src="https://img.shields.io/badge/npm-CB3837?style=for-the-badge&logo=npm&logoColor=white"/>
<img src="https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white"/>
<img src="https://img.shields.io/badge/PostgeSQL-003545?style=for-the-badge&logo=postgre&logoColor=white"/>
<img src="https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white"/>
</h3>

API em Java 11 com spring-boot 2.7.11, padrão MVC.</br>
API de Serviço Java 11 com spring-boot 2.7.11.</br>
Frontend em Angular 15.2.0.</br>
Database utiliza PostgreSQL 13.</br>

</br>
<h3>
<img src="https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white"><sup><sub><br><p><i>** powered by magrinho **</i></p></sup></sub></img>
</h3>

## Executando em ambiente local com Docker 🐋
A partir da pasta raiz do projeto, acesse a pasta docker-compose e execute o comando para iniciar o container:
> docker-compose up --build
>

Feito isso, verifique se os containers estão "up" e faça uma requisição na API utilizando Postman ou outro software de sua preferência:
> localhost:8080/infracoes/findAll
>

Acesse o Frontend em:
> http://localhost:8081/infracoes
>

O container postgresql é dependência do container da API, então irá iniciar antes do build, automaticamente.
Senão, utilize o comando abaixo antes de executar o backend novamente:
> docker-compose up -d postgresql
>

</br>

### O serviço de simulador de infrações executará ininterruptamente, enviando uma nova infração para a API a cada 3 segundos! É recomendável que pare o container "radar" após algumas inserções:
> docker-compose stop radar
>

</br>
<img src="https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white"/></br>

## Executando em ambiente local com Maven
### Na raiz da pasta do backend, execute:
> mvn install
>
> mvn spring-boot:run 
> 

</br>

#### Ou utilize a IDE de sua preferência.

</br>

<h3>
<img src="https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white"/>
<img src="https://img.shields.io/badge/npm-CB3837?style=for-the-badge&logo=npm&logoColor=white"/></br>
</h3>

Para inicializar o frontend, utilize o comando:
> npm install && ng serve 
>

</br>

# Frontend e Estrutura de Containers

<p align="center">
  <img width="460" height="500" src="frontend/src/assets/screen.png">
</p>

<p align="center">
  <img width="460" height="400" src="frontend/src/assets/docker.png">
</p>
