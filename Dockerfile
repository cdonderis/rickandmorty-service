FROM openjdk:11
EXPOSE 8080
ADD ./target/rickandmorty-0.0.1-SNAPSHOT.jar rickandmorty.jar
ENTRYPOINT ["java", "-jar", "/rickandmorty.jar"]