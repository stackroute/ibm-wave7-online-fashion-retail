FROM openjdk:11
ADD ./target/manufacturer-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8189
ENTRYPOINT ["java","-jar", "app.jar"]
