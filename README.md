# Spring Cloud Aws Lambda

### Summary
Application exposes users endpoint using spring cloud. 
* http://localhost:8080/users

### Running the app
 * gradle clean build
 * gradle bootRun
 * curl -v -H "Accept: application/json" -H "Content-type: application/json" -X POST  -d '[{"pin":{"value":"1"}}]'    http://localhost:8080/users
 * you can also check the component test file to see the requests
 
 
