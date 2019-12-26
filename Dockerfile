FROM openjdk:8-jre

COPY build/libs/*.jar /opt/app.jar

CMD [ "java", "-jar", "/opt/app.jar" ]