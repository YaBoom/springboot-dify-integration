# springboot-dify-integration-demo

#### 介绍
基于dify搭建的聊天机器人应用，springboot进行api调用实例

#### 依赖环境
jdk 17
spring-boot 3.4.6

#### 功能概要

通过spring-web提供的RestTemplate来发生post请求给DIFY的应用api，并自定义固定格式的dify要求的DifyBatchReqMessage和DifyBatchResMessage来接受apiurl传输过来的响应集。
