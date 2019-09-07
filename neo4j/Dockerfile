FROM openjdk:11

ADD ./target/neo4j-0.0.1-SNAPSHOT.jar /usr/src/neo4j-0.0.1-SNAPSHOT.jar

EXPOSE 8191
ENTRYPOINT ["java","-jar", "neo4j-0.0.1-SNAPSHOT.jar"]