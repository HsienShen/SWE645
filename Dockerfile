#Author: Naumi Varma & Hsien-Tien Shen
#This Dockerfile contains the location of war file
FROM tomcat:8.5-jdk15

COPY Assignment1/src/main/webapp/Assignment1.war /usr/local/tomcat/webapps/
