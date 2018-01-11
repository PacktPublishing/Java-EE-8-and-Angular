#FROM openjdk:8-jre-alpine

#COPY target/jaxrs-ee8.jar /app.jar

#CMD ["/usr/bin/java", "-jar", "/app.jar"]
FROM payara/micro:5-SNAPSHOT

COPY target/jaxrs-ee8.war $DEPLOY_DIR

