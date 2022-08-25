FROM openjdk:20-ea-11-slim
VOLUME /tmp
ADD . .
COPY  build/libs/usersApp-0.0.1-SNAPSHOT.jar usersApp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","usersApp-0.0.1-SNAPSHOT.jar"]