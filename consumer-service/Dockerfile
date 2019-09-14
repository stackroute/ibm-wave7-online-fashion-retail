FROM openjdk:11
WORKDIR usr/src
ADD ./target/consumer-service-0.0.1-SNAPSHOT.jar /usr/src/consumer-service-0.0.1-SNAPSHOT.jar
EXPOSE 8190
ENTRYPOINT ["java","-jar","/usr/src/consumer-service-0.0.1-SNAPSHOT.jar"]
