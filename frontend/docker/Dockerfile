#FROM node:18.10-alpine AS build
#WORKDIR /usr/src/app
#COPY package*.json ./
#RUN npm install
#COPY . .
#RUN npm run build
#
#FROM nginx:1.21.0-alpine
#ENV TZ=America/Sao_Paulo
#WORKDIR /usr/share/nginx/html
#COPY ./docker/app.conf /etc/nginx/conf.d/app.conf
#RUN sed -i.bak 's/listen\(.*\)80;/listen 8080;/' /etc/nginx/conf.d/default.conf
#
#COPY --from=build /usr/src/app/dist .
#
#RUN chown -R nginx:nginx /usr/share/nginx/html && chmod -R 755 /usr/share/nginx/html && \
#        chown -R nginx:nginx /var/cache/nginx && \
#        chown -R nginx:nginx /var/log/nginx && \
#        chown -R nginx:nginx /etc/nginx/conf.d
#
#RUN touch /var/run/nginx.pid && \
#        chown -R nginx:nginx /var/run/nginx.pid
#
#USER nginx
#
#EXPOSE 8080
#CMD ["nginx", "-g", "daemon off;"]
#

FROM node:18.10-alpine AS build
WORKDIR /dist/src/app
RUN npm cache clean --force
COPY . .
RUN npm install
RUN npm run build --prod

FROM nginx:latest AS ngi
COPY --from=build /dist/src/app/dist/frontend /usr/share/nginx/html
COPY --from=build /dist/src/app/nginx /etc/nginx/conf.d/
#COPY /nginx.conf  /etc/nginx/conf.d/default.conf
EXPOSE 80
