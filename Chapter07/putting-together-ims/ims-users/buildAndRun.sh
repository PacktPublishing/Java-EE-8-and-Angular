#!/bin/sh
mvn clean package && docker build -t org.jee8ng/ims-users .
docker rm -f ims-users || true && docker run --rm -d -p 8081:8080 --name ims-users org.jee8ng/ims-users
 
