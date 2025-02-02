FROM mdernst/cf-ubuntu-jdk21
ARG JAR_FILE=build/libs/SpringSecurityTestTask-0.0.1-SNAPSHOT.jar
WORKDIR app/
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]