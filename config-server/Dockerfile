FROM openjdk:11

ADD ./target/config-server-1.0.0.jar /usr/src/config-server-1.0.0.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "config-server-1.0.0.jar"]
