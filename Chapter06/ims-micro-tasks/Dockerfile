#FROM openjdk:8-jre-alpine

#COPY target/ims-micro-*.jar /app.jar

#CMD ["/usr/bin/java", "-jar", "/app.jar"]
FROM payara/micro:5-SNAPSHOT

COPY target/ims-micro-*.war $DEPLOY_DIR

