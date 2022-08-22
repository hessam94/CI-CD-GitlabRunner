# CICDtest


## Scenario

In this project we have two simple REST function using Spring boot framework. The Java app runs in docker container and pushed into gitlab.  

- to execute the application via gitlab runner, first we need to create a executable file (demo.jar) of the wholw project and then push it on gitlab along with other source codes.  
- After pushing on gitlab, the gitlab runner automatically is triggered and starts the project. the steps of project to be executed is written in a git-lab.yaml file and is placed on gitlab profile, under CI/CD section.  
- We also need to provide the docker file to create and run Java app inside the container.
- The gitlab runner needs to be hosted on a machine. We used local environment to set up and register the runner.  
- in the end we could test it with postman software to make sure it on provided port and link. 


## Docker file
```
FROM openjdk:17.0.2-jdk-slim-bullseye
COPY ./target/demo.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

``` 
## git-lab.yaml 

```
before_script:
  - pwd
 
stages:          # List of stages for jobs, and their order of execution
  - build
 
 
build-job:      # This job runs in the build stage, which runs first.
  stage: build
  script:
    - docker build -t cicd/spring-test .
    - docker run -p 8080:8080 cicd/spring-test

```

## useful links

-  [Set up gitlab runner](https://docs.gitlab.com/runner/register/)
-  [Gitlab Runner tutorial video](https://www.youtube.com/watch?v=qP8kir2GUgo) 
