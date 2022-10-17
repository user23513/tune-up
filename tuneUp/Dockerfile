FROM openjdk:11-jre
ARG JAR_FILE=target/*.jar
COPY wallet_tuneup/* /wallet_tuneup/
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar", "/app.jar"]

