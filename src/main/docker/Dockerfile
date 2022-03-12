FROM openjdk:11-jre-slim

# 环境变量
ENV WORK_PATH /home/project/factos
ENV APP_NAME facto-0.0.1-SNAPSHOT.jar
ENV APP_VERSION 0.0.1

EXPOSE 8080
#USER
#USER user:group
#VOLUME
VOLUME ["/home/project", "/tmp/data"]
#ADD
#COPY
COPY $APP_NAME $WORK_PATH/
#LABEL
#STOPSIGNAL
#ARG
#ONBUILD
# WORKDIR
WORKDIR $WORK_PATH
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone

# ENTRYPOINT
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom"]

CMD ["-jar", "-Xmx512m", "facto-0.0.1-SNAPSHOT.jar"]