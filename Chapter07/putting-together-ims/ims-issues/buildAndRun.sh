#!/bin/sh
mvn clean package && docker build -t org.jee8ng/ims-issues .
docker rm -f ims-issues || true && docker run --rm -d -p 8082:8080 --name ims-issues org.jee8ng/ims-issues 
