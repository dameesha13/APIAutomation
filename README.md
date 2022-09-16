# API&nbsp;Automation

This project contains automated test cases for a publicly available REST API.

#### **Technology Stack**

 List of technologies used within the project,
* Java
* Rest Assured
* TestNG
* Maven
* Git
* lombok
* jackson

###### Checkout the branch
      git clone (https://github.com/dameesha13/APIAutomation.git)

###### Run the code using maven goal

```
mvn clean install test -DsuiteXmlFile="AllServicesRegression.xml" 
```

Project structure as below.

``` bash
.
├── src
    ├── main
       ├── java
           ├── constant
           ├── requestdto
           ├── responsedto
           ├── service
           ├── util
    ├── test
        ├── java
        ├── resources
            ├── config
            ├── data
            ├── RequestBodyTemplates
            ├── RequestHeaderTemplates
            ├── testng # TestNG xml files are located in src/test/resources/testng/ directory.
   ├── pom.xml
   ├── README.md   
...


