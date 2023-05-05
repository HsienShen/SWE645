#Author: Naumi Varma & Hsien-Tien Shen
#test Jenkins
#This Dockerfile contains the location of war file
FROM maven:3.8.5-openjdk-17-slim AS build
COPY SurveyApp/SurveyApp/src /home/app/src
COPY SurveyApp/SurveyApp/pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /opt/app

COPY --from=build /home/app/target/SurveyApp-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
