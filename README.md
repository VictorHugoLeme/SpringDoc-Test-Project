# SpringDoc-Test-Project

Basic SpringDocV2 and OpenAPIv3 integration with Spring Boot 3.

## Running

Just run the application and access "/swagger-ui/index.html"

## Configuring

[SpringDocConfig.java](https://github.com/VictorHugoLeme/SpringDoc-Test-Project/blob/main/src/main/java/com/example/springdoctestproject/config/SpringDocConfig.java)
contains some basic settings such as title, description, version and license. More settings can be added.

You can change the Swagger path at 
[application.yml](https://github.com/VictorHugoLeme/SpringDoc-Test-Project/blob/main/src/main/resources/application.yml) 
file, as well as operations sorting and other settings.
All properties can be found at 
[Springdoc Properties](https://springdoc.org/v2/#properties).
