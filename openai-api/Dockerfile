FROM openjdk:8-jre-slim
MAINTAINER zeddic

ENV PARAMS=""

ENV TZ=PRC

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# 添加应用
ADD target/openai-api.jar /openai-api.jar
## 在镜像运行为容器后执行的命令
ENTRYPOINT ["sh","-c","java -jar $JAVA_OPTS /openai-api.jar $PARAMS"]
