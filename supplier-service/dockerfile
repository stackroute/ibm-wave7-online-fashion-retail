FROM openjdk:11
WORKDIR usr/src
COPY ./target/supplier-service-0.0.1-SNAPSHOT.jar /usr/src/supplier-service-0.0.1-SNAPSHOT.jar
EXPOSE 8188
ENTRYPOINT ["java","-jar","/usr/src/supplier-service-0.0.1-SNAPSHOT.jar"]
