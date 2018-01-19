# Build
mvn clean package && docker build -t org.jee8ng/ims-chat .

# RUN

docker rm -f ims-chat || true && docker run -d -p 8080:8080 -p 4848:4848 --name ims-chat org.jee8ng/ims-chat 