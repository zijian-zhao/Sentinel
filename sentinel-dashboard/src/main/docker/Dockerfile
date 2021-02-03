FROM openjdk:8-jre-alpine
RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g' /etc/apk/repositories
RUN apk --no-cache add curl
VOLUME /tmp
ADD sentinel-dashboard.jar sentinel.jar
ENV LANG C.UTF-8
ENTRYPOINT ["java","-Xmx512m","-Xms128m","-Djava.security.egd=file:/dev/./urandom", "-Dserver.port=8858", "-Dcsp.sentinel.dashboard.server=localhost:8858", "-jar","/sentinel.jar"]