FROM amazoncorretto:21-alpine-jdk
COPY target/medical_proxy-0.0.1-SNAPSHOT.jar medical_proxy-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/medical_proxy-0.0.1-SNAPSHOT.jar"]