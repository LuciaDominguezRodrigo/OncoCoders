#########################
#  ANGULAR COMPILATION  #
#########################
# Base image to build the Angular project
FROM node:23-alpine3.20 AS angular

# Choose container working directory where we are going to execute commands
WORKDIR /code

# Copy project dependencies from local project to compilation container directory
COPY ProjectFrontend/package*.json ProjectFrontend/angular.json ProjectFrontend/tsconfig*.json /code/

# Execute command in compilation container to download project dependencies
RUN npm install --legacy-peer-deps

# Copy project source from local project to compilation container directory
COPY ProjectFrontend/src /code/src

# Compile project using already downloaded libraries configurating the base href
RUN npm run build -- --configuration production --base-href=/new/

#########################
# COMPILATION CONTAINER #
#########################
# Base image to build the project
FROM maven:3.9.9-eclipse-temurin-21 as builder

# Choose container working directory where we are going to execute commands
WORKDIR /project

# Copy project dependencies from local project to compilation container directory
COPY ProjectBackend/pom.xml /project

# Execute command in compilation container to download project dependencies
RUN mvn clean verify --fail-never

# Copy project source from local project to compilation container directory
COPY ProjectBackend/src /project/src
COPY --from=angular /code/dist/project-front-end /project/src/main/resources/static/new

# Compile project using already downloaded libraries
RUN mvn package -DskipTests

#########################
# APPLICATION CONTAINER #
#########################
FROM openjdk:21-jdk-slim

# Choose container working directory where we can find JAR file
WORKDIR /usr/app

# Copy JAR from compilation container to application container directory
COPY --from=builder /project/target/*.jar /usr/app

# Start expose port from container
EXPOSE 8443

# Execute command
CMD [ "java", "-jar", "OncoCodersWebApp-0.0.1-SNAPSHOT.jar" ]