FROM openjdk:11-jdk

WORKDIR /app

COPY target/api-0.0.1-SNAPSHOT.jar /app/

EXPOSE 80

ENV USER_DB=$USER_DB
ENV PASS_DB=$PASS_DB
ENV DATABASE_DB=$DATABASE_DB

CMD ["java", "-jar", "api-0.0.1-SNAPSHOT.jar"]