FROM adoptopenjdk/openjdk11


COPY ./build/libs/extension-checker-0.0.1-SNAPSHOT.jar extension-checker.jar

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod", "/extension-checker.jar"]
