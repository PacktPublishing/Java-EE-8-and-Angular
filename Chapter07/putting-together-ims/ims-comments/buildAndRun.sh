#!/bin/sh
mvn clean package && docker build -t org.jee8ng/ims-comments .
docker rm -f ims-comments || true && docker run -d -p 8083:8080 --name ims-comments --link ims-users org.jee8ng/ims-comments 
