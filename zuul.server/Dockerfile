FROM openjdk:8-jdk-alpine
VOLUME /tmp
ENV EUREKA_CLIENT_SERVICEURL_DEFAULTZONE='http://netflix-eureka-naming-server:8761/eureka/'
ADD target/zuul.server-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8762