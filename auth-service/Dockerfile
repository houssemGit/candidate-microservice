FROM  openjdk:8
EXPOSE 8081
ADD /target/evaluation-service-0.0.1-SNAPSHOT.jar evaluation-service.jar
ENTRYPOINT ["java", "-jar", "auth-service.jar"]
