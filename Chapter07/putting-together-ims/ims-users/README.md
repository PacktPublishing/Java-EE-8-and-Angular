# Build
mvn clean package && docker build -t org.jee8ng/ims-users .

# RUN

docker rm -f ims-users || true && docker run -d -p 8080:8080 -p 4848:4848 --name ims-users org.jee8ng/ims-users 