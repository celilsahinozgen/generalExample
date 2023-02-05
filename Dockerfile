FROM adoptopenjdk/openjdk11
EXPOSE 8080
ARG JAR_FILE=target/project-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} genelprojedocker.jar
ENTRYPOINT ["java","-jar","/genelprojedocker.jar"]