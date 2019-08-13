# Spring Cloud Contract

You always need confidence when pushing new features into a new application or service in a distributed system. To that end, this project provides support for consumer-driven contracts and service schemas in Spring applications, covering a range of options for writing tests, publishing them as assets, and asserting that a contract is kept by producers and consumers — for both HTTP and message-based interactions.

## Quickstart

 From the command line do:
```shell
$ docker-compose up --build -d
```

## cURL for tests

 From the command line do:
```shell
$ curl -X POST "http://localhost:8080/api/beer" -H "accept: */*" -H "Content-Type: application/json" -d 
    "{ \"name\": \"India Pale Ale Opa Bier\", \"alcoholTenor\": \"6,1%\", 
    \"description\": \"Na cerveja IPA Opa Bier artesanal, para atingir o equilíbrio entre aroma e amargor, a Opa Bier harmoniza 3 lúpulos especiais nessa receita de sabor intenso e cítrico.\", 
    \"ibu\": \"37\", \"style\": \"India Pale Ale\"}"
    
$ curl -X POST "http://localhost:8080/api/beer" -H "accept: */*" -H "Content-Type: application/json" -d 
    "{ \"name\": \"Heineken Larger Beer\", \"alcoholTenor\": \"5,4%\", 
    \"description\": \"Uma cerveja lager pálido com 5% de álcool por volume produzido pela empresa cervejeira holandesa Heineken International.\", 
    \"ibu\": \"36\", \"style\": \"Larger\"}"
```

Microservices 
- [spring-boot-cdc-jms-producer](https://github.com/RicardoSabinolrs/spring-cloud-contract/tree/master/spring-boot-cdc-jms-producer)
- [spring-boot-cdc-jms-receiver](https://github.com/RicardoSabinolrs/spring-cloud-contract/tree/master/spring-boot-cdc-jms-receiver)
- [spring-boot-cdc-rest-api](https://github.com/RicardoSabinolrs/spring-cloud-contract/tree/master/spring-boot-cdc-rest-api)

![Alt text](docs/services.jpg?raw=true "Title")
