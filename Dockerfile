FROM openjdk:8 AS builder
RUN git clone https://github.com/chojuhyun1016/addr.git .
RUN chmod +x ./addr/gradlew
RUN ./gradlew bootWar

FROM openjdk:8-jre-alpine
RUN mkdir /opt/app/addr
WORKDIR /opt/app/addr
COPY --from=builder build/libs/*.war addr.war
VOLUME ["/data1/log"]
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/addr.war", "-Djava.net.preferIPv4Stack=true"]
