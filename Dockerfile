# Use Maven to build and then run the jar
FROM eclipse-temurin:17-jdk-jammy AS build
WORKDIR /app
COPY . /app
RUN ./mvnw -DskipTests package

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/target/evaluacion-docente-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
