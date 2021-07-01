FROM node:14

WORKDIR /usr/src/app

COPY package*.json .

RUN npm cache clean --force

RUN npm i

COPY . .

EXPOSE 4200

CMD /usr/src/app/node_modules/.bin/ng serve --host 0.0.0.0 --disableHostCheck
