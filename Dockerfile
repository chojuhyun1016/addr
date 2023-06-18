FROM adoptopenjdk:8-jdk-hotspot AS builder
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew bootWar

FROM adoptopenjdk:8-jdk-hotspot
COPY --from=builder build/libs/*.war addr.war
VOLUME ["/data1/log"]
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/addr.war"]
