FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/payment.calculator.service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 9000