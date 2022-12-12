FROM openjdk:11
ADD build/libs/*.jar abakry/dockerapp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "dockerapp.jar"]