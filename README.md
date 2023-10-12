# Rick and Morty Api Rest
## Run the poroject
1. `./mvnw clean install`
2.  `./mvnw spring-boot:run`

## Project Structure
To generate the project structure I have used Spring initializer from (https://start.spring.io.). I selected Maven like 
project management, Java 11 and next dependencies to start this project:

    1.Spring Data JPa.

    2.Spring Web.
    
    3.H2 Database.

In utils package locates RestTemplateConfig, to implement deserialize and mapping from response Api. Also I'd added a 
class to mapped JSON with my object "CharacterInfo" and DateFormatter to work with string data format from API.

I created two models to difference between Character information and Episode Information, and I only deserialized 
attributes that I have needed at business logic.

I have not develop test because I don't have time to continue, and the finally response of my service need a DTO
to return only the specified attributes. 


I hope you value the rest of the project, all the best!


