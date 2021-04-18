FROM openjdk:8-jdk-alpine

RUN apk update && apk upgrade
RUN apk add curl wget curl bash vim

RUN mkdir -p /app && chmod -R 750 /app
WORKDIR /app

ADD target/*-SNAPSHOT.jar ./app.jar

ENTRYPOINT exec java -jar app.jar
