# Build
mvn clean package && docker build -t org.jee8ng/ims-comments .

# RUN

docker rm -f ims-comments || true && docker run -d -p 8080:8080 -p 4848:4848 --name ims-comments org.jee8ng/ims-comments 