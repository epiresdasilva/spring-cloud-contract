# Spring Cloud Contract

You always need confidence when pushing new features into a new application or service in a distributed system. To that end, this project provides support for consumer-driven contracts and service schemas in Spring applications, covering a range of options for writing tests, publishing them as assets, and asserting that a contract is kept by producers and consumers — for both HTTP and message-based interactions.

## Quickstart

 From the command line do:
```shell
$ git clone https://github.com/RicardoSabinolrs/spring-cloud-contract.git
$ cd spring-cloud-contract/
$ mvn clean install -U
$ docker-compose up --build -d
```
> :dart: You can access the API documentation via browser: http://localhost:8080/swagger-ui.html

## Project description

The project uses:

- [Java 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
- [Maven](https://github.com/apache/maven)
- [Spring Boot](http://github.com/spring-projects/spring-boot)
- [Spring Data JPA](https://github.com/spring-projects/spring-data-jpa)
- [H2](https://github.com/h2database/h2database)
- [Lambok](https://github.com/rzwitserloot/lombok)
- [Swagger](https://github.com/swagger-api)
- [jUnit](https://github.com/junit-team/junit5)
- [Hamcrest](https://github.com/hamcrest/JavaHamcrest)
- [Mockito](https://github.com/mockito/mockito)
- [Jayway](https://github.com/json-path)
- [OpenJ9](https://github.com/eclipse/openj9)
- [Docker](https://docs.docker.com/engine/reference/builder/)

Some techniques:
- [Domain Driven Design](https://en.wikipedia.org/wiki/Domain-driven_design)
- [Dependency Injection](https://en.wikipedia.org/wiki/Dependency_injection)
- [TDD with Mocks and Stubs](https://en.wikipedia.org/wiki/Test-driven_development)
- [Test-First Development](https://pt.wikipedia.org/wiki/Test_Driven_Development)
- [OpenAPI Specification](https://swagger.io/specification/)
- [Container](https://www.docker.com/resources/what-container)
