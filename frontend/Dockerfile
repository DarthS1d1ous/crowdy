FROM node:latest as build

WORKDIR /usr/src/app

COPY ../angular-frontend .

RUN npm install

CMD ["npm", "start"]
