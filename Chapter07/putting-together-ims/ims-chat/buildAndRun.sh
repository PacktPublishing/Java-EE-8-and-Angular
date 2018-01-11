#!/bin/sh
mvn clean package && docker build -t org.jee8ng/ims-chat .
docker rm -f ims-chat || true && docker run -d -p 8084:8080 --name ims-chat org.jee8ng/ims-chat 
