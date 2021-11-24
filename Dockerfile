FROM adoptopenjdk/openjdk11:x86_64-alpine-jre-11.0.13_8
WORKDIR /app
COPY cora-app/build/libs/cora-app.jar /app/

CMD [ "java", "-jar", "./cora-app.jar" ]