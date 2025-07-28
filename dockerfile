FROM eclipse-temurin:17-jdk
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} springsecuritydemo.jar
ENTRYPOINT ["java", "-jar", "/springsecuritydemo.jar"]
