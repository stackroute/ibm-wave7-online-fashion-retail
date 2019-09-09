FROM openjdk:11
WORKDIR usr/src
COPY ./target/supplier-0.0.1-SNAPSHOT.jar supplier-0.0.1-SNAPSHOT.jar
EXPOSE 8188
ENTRYPOINT ["java","-jar","/usr/src/supplier-0.0.1-SNAPSHOT.jar"]
