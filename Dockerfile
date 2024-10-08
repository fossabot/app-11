FROM eclipse-temurin:17
ARG JAR_FILE=target/*.jar
COPY ./target/licence-validation.jar licence-validation.jar
LABEL authors="Yasin Kaddori"
EXPOSE 8080
ENTRYPOINT ["java","-jar","/licence-validation.jar"]