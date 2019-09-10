FROM openjdk:11
COPY ./target/neo4j-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","app.jar"]