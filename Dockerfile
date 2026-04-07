FROM quay.io/quarkus/quarkus-docker:21.0.0-java17

WORKDIR /work/
COPY target/lib/* /work/lib/
COPY target/*-runner.jar /work/application.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "application.jar"]
