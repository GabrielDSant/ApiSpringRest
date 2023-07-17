FROM openjdk:11-jdk

WORKDIR /app

COPY target/api-0.0.1-SNAPSHOT.jar /app/

EXPOSE 80

CMD ["java", "-jar", "api-0.0.1-SNAPSHOT.jar"]