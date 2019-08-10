FROM adoptopenjdk/openjdk11-openj9:alpine-slim

MAINTAINER SabinoLab

COPY target/spring-boot-cdc-jms-producer-*.jar /sabino-app/app.jar
COPY scripts/entrypoint.sh /sabino-app

ENTRYPOINT /sabino-app/entrypoint.sh
