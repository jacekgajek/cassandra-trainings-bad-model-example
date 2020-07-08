FROM openjdk:11-jre
COPY ./target/*jar-with-dependencies.jar /app.jar
