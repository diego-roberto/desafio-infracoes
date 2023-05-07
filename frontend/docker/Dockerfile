FROM node:18.10-alpine AS build
WORKDIR /dist/src/app
RUN npm cache clean --force
COPY . .
RUN npm install
RUN npm run build --prod

FROM nginx:latest AS ngi
COPY --from=build /dist/src/app/dist/frontend /usr/share/nginx/html
COPY --from=build /dist/src/app/nginx /etc/nginx/conf.d/
EXPOSE 80
