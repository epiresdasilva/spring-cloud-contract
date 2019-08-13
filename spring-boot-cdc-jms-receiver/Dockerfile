FROM adoptopenjdk/openjdk12-openj9

MAINTAINER SabinoLab

COPY target/spring-boot-cdc-jms-receiver-*.jar /sabino-app/app.jar
COPY scripts/entrypoint.sh /sabino-app

ENTRYPOINT /sabino-app/entrypoint.sh