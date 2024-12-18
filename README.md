Developed a microservice arquitecture using:
Java Maven v.21
SpringBoot Version 3.4.0
SpringBoot-Cloud 2024.0.0
SpringBoot-actuator (api-gateway)
SpringBoot-eureka-server (server)
SpingBoot with MySQL
SpringBoot with MongoDB

# General Information
-Project developed using Spring-Boot 3.4.0
-Project developed using Java Maven 21
-The "school-service" microservice uses a MySQL Database
-The "student-service" microservice uses a MongoDB Database

# Dependencies school-service
-Spring Web
-Lombok
-Spring Data JPA
-MySQL Driver
-Eureka Discovery Client

# Dependencies student-service
-Spring Web
-Lombok
-Spring Data JPA
-Spring Data MongoDB

# Dependencies for service-registry
-Eureka Server

# Dependencies for cloud-gateway
-Spring Boot Actuator
-Eureka Discovery Client
-Gateway

# Config Instructions
-Make sure all of the 4 applications are running the same version of dependencies or else there will be a mismatch
and the build will fail. Specially with spring-cloud dependencies.
-The cloud-gateway is the only application that uses an application.yml this is because of how the paths are mapped. Please remove application.properties file
or else there will be an error on the build. 
-If any of the services doesnt register on the Eureka server make sure to check the application.properties file. 
I recommend not using the default 8080 port. 

# How to run

1. Run the service-registry (this is the Eureka Server)
2. Run the cloud-gateway (api-gateway)
3. Run the student-service
4. Start MySQL Database
5. Run the school-service

# How to Test
-Install Postman
- Run POST http://localhost:8083/school (if you changed the port of the api-gateway you should change the port number of this URL)
