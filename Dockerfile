FROM adoptopenjdk/openjdk11


COPY ./build/libs/checker-0.0.1-SNAPSHOT.jar checker.jar

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod", "/checker.jar"]
