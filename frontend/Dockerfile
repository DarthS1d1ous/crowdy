FROM node:10.23-alpine as node

WORKDIR /usr/src/app

COPY ../angular-frontend .

RUN npm install

CMD ["npm", "start"]
