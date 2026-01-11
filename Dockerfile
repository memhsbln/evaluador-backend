# Build stage
FROM eclipse-temurin:17-jdk-focal AS build
WORKDIR /app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml pom.xml
COPY src src
RUN ./mvnw -DskipTests package -P '!native'

# Run stage
FROM eclipse-temurin:17-jre-focal
WORKDIR /app
ARG JAR_FILE=target/*.jar
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]

