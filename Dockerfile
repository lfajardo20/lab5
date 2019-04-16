FROM openjdk:8-jdk-alpine

VOLUME /tmp

ARG JAR_FILE=./Task1/build/libs/Spring-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

# WORKDIR /app

# RUN pwd

# RUN sh -c 'touch Spring-0.0.1-SNAPSHOT.jar'

# EXPOSE 8080

RUN pwd

ENTRYPOINT [ "java", "-jar","app.jar" ]