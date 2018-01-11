# Build
mvn clean package && docker build -t org.jee8ng/ims-issues .

# RUN

docker rm -f ims-issues || true && docker run -d -p 8080:8080 -p 4848:4848 --name ims-issues org.jee8ng/ims-issues 