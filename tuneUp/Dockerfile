FROM openjdk:11-jre
ENV TZ=Asia/Seoul
ENV LANGUAGE ko_KR.UTF-8
ENV LANG ko_KR.UTF-8
ENV LC_ALL ko_KR.UTF-8 
ARG JAR_FILE=target/*.jar
ENTRYPOINT ["java","-jar", "/app.jar"]
