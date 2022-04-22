FROM  openjdk:8
EXPOSE 8081
ADD /target/authentication-microservice-0.0.1-SNAPSHOT.jar auth-service.jar
ENTRYPOINT ["java", "-jar", "auth-service.jar"]
