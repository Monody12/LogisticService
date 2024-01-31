FROM openjdk:17-jdk
VOLUME /tmp
COPY build/libs/LogisticService-1.0-SNAPSHOT.jar app.jar
#CMD ["sh","-c","java -jar app.jar"]
EXPOSE 8080
ENTRYPOINT ["java", "-jar","app.jar"]