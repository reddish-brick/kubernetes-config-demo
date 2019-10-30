FROM maven:3.3.9-jdk-8-alpine
RUN mkdir /app
COPY ./build/libs/kubernetes-demo-0.0.1-SNAPSHOT.jar /app
#COPY /database-init.sh /app
#COPY /initialize_db.sql /app
WORKDIR /app
#RUN apk update && apk add mysql mysql-client
#ENTRYPOINT ["/app/database-init.sh"]
CMD java -jar kubernetes-demo-0.0.1-SNAPSHOT.jar









