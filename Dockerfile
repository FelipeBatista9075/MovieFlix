FROM eclipse-temurin:17
LABEL authors="FelipeB"
WORKDIR /app
COPY target/movieflix-0.0.1-SNAPSHOT.jar /app/movieflix.jar
ENTRYPOINT ["java", "-jar", "movieflix.jar"]