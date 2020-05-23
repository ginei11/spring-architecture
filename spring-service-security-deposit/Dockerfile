FROM openjdk:13
VOLUME  /tmp
EXPOSE 8006
ADD ./target/spring-service-security-deposit-0.0.1-SNAPSHOT.jar   service-deposit.jar
ENTRYPOINT ["java","-jar","/service-deposit.jar"]