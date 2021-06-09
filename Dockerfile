FROM amazoncorretto:11
ARG JAR_FILE=build/libs/grpc-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
COPY run.sh .
CMD ["/run.sh"]