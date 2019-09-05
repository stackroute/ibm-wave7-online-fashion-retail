FROM openjdk:11

ADD ./target/zuul-api-0.0.1-SNAPSHOT.jar /usr/src/zuul-api-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "zuul-api-0.0.1-SNAPSHOT.jar"]