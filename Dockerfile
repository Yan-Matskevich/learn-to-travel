FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/web-ui-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]

#docker build -t web-ui:0.1 .
#docker run -d -p 8081:8081 -t web-ui:0.1
