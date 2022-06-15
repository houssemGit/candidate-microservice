FROM  openjdk:8
EXPOSE 8083
ADD /target/candidature-service-0.0.6-SNAPSHOT.jar candidature-service.jar
ENTRYPOINT ["java", "-jar", "candidature-service.jar"]