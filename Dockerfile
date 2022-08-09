FROM openjdk:17.0.2-jdk-slim-bullseye
COPY ./target/demo.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
