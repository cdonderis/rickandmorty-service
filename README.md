# Rick and Morty Api Rest
### Download project
``https://github.com/cdonderis/rickandmorty-service.git``
### Run the poroject
1.  `./mvnw clean install`
2.  `./mvnw spring-boot:run`
### Skip test
`./mvnw spring-boot:run -DskipTests`
### Only run test
`./mvnw test`

## Docker
### Docker Build
`docker build -t rickandmortyservice:1.0 .`
### Verify succes build
`docker images`
### Docker Run
`docker run -p 8080:8080 rickandmortyservice:1.0`

## Project Structure
To generate the project structure I have used Spring initializer from (https://start.spring.io.). I selected Maven like 
project management, Java 11 and next dependencies to start this project:

    1.Spring Data JPa.

    2.Spring Web.
    
    3.H2 Database.

    4.Mockito

In utils package locates RestTemplateConfig, to implement deserialize and mapping from response Api. Also I'd added a 
class to mapped JSON with my object "CharacterInfo" and DateFormatter to work with string data format from API.

I created two models to difference between Character information and Episode Information, and I only deserialized 
attributes that I have needed at business logic. To adapt response I created a Data Transfer Object named CharacterDTO.

I used Mockito for testing because I've needed mock RestTemplate to avoid direct API calls during test. I only test
main method of CharacterInfoServiceImpl because I can cover 66% classes and 70% lines of my project. I could implement
a CharacterInfoResource test to cover my ApiRest too, but I think that with the test I have done, Testing it's solved.



