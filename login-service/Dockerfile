FROM openjdk:11
ADD ./target/login-service-0.0.1-SNAPSHOT.jar /usr/src/login-service-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar","login-service-0.0.1-SNAPSHOT.jar"]
