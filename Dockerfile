FROM openjdk:8 AS builder
RUN git clone https://github.com/chojuhyun1016/addr.git
WORKDIR /addr
RUN chmod +x /addr/gradlew \
 && /addr/gradlew bootWar

FROM openjdk:8-jre-alpine
RUN mkdir -p /opt/app
COPY --from=builder /addr/build/libs/addr.war /opt/app/addr.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/app/addr.war", "-Djava.net.preferIPv4Stack=true"]
