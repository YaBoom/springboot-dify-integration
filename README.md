# Spring Boot Dify Integration

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4.6-green)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

基于Spring Boot集成Dify开放接口的完整解决方案，通过RestTemplate实现POST请求调用Dify API，为企业级应用提供灵活的AI集成能力。

## 🌟 特性

- ✅ 与Dify API无缝集成
- ✅ 基于Spring Boot 3.4.6构建
- ✅ 支持REST API调用
- ✅ 集成MyBatis-Plus ORM框架
- ✅ 集成Druid连接池监控
- ✅ 支持MySQL数据库操作
- ✅ 使用FastJSON进行数据处理
- ✅ 集成Lombok减少样板代码

## 🛠️ 技术栈

- **Java 17**: 使用最新的长期支持版本
- **Spring Boot 3.4.6**: 快速开发框架
- **Spring Web**: REST API开发
- **MyBatis-Plus**: 增强的ORM框架
- **Druid**: 阿里巴巴数据库连接池
- **FastJSON**: JSON数据处理
- **Lombok**: 减少样板代码
- **MySQL**: 数据库存储

## 📋 架构概述

本项目采用经典的分层架构设计：

```
src/
├── main/
│   ├── java/
│   │   └── org/example/springbootdifyintegration/
│   │       ├── controller/     # API控制器层
│   │       ├── service/        # 业务逻辑层
│   │       ├── model/          # 数据模型层
│   │       ├── config/         # 配置类
│   │       └── util/           # 工具类
│   ├── resources/
│   │   ├── application.yml     # 应用配置
│   │   └── mapper/             # MyBatis映射文件
│   └── webapp/
└── test/
```

## 🚀 快速开始

### 环境要求

- JDK 17+
- Maven 3.6+
- MySQL 5.7+

### 1. 克隆项目

```bash
git clone https://github.com/YaBoom/springboot-dify-integration.git
cd springboot-dify-integration
```

### 2. 配置数据库

创建MySQL数据库并执行初始化脚本：

```sql
CREATE DATABASE dify_integration CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 3. 配置应用参数

修改 `src/main/resources/application.yml` 文件：

```yaml
spring:
  datasource:
    druid:
      url: jdbc:mysql://localhost:3306/dify_integration
      username: your_username
      password: your_password
      driver-class-name: com.mysql.cj.jdbc.Driver
  # Dify API配置
  dify:
    api:
      base-url: https://api.dify.ai/v1
      api-key: your_dify_api_key

server:
  port: 8080
```

### 4. 编译运行

```bash
# 编译项目
mvn clean compile

# 打包应用
mvn clean package -DskipTests

# 运行应用
java -jar target/springboot-dify-integration.jar
```

或者直接使用Maven插件运行：

```bash
mvn spring-boot:run
```

### 5. 访问应用

应用启动后，默认访问地址：http://localhost:8080

## 🔧 API接口

### Dify API集成

#### POST /api/dify/chat
发起聊天对话请求

请求体：
```json
{
  "inputs": {},
  "query": "你好，介绍一下自己",
  "response_mode": "blocking",
  "conversation_id": "",
  "user": "user-123"
}
```

响应体：
```json
{
  "answer": "我是Dify助手...",
  "conversation_id": "conv-456",
  "metadata": {}
}
```

## 🧪 测试

运行单元测试：

```bash
mvn test
```

运行集成测试：

```bash
mvn verify
```

## 📦 部署

### Docker部署

项目支持Docker容器化部署：

```dockerfile
FROM openjdk:17-jdk-slim
COPY target/springboot-dify-integration.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

构建并运行：

```bash
docker build -t springboot-dify-integration .
docker run -p 8080:8080 springboot-dify-integration
```

### 传统部署

1. 将打包好的JAR文件上传到服务器
2. 设置环境变量和配置文件
3. 启动应用：`nohup java -jar springboot-dify-integration.jar &`

## 🤝 贡献

欢迎提交Issue和Pull Request来改进此项目！

### 开发流程

1. Fork此仓库
2. 创建特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送分支 (`git push origin feature/AmazingFeature`)
5. 创建Pull Request

## 📄 许可证

本项目采用 [MIT License](LICENSE) 许可证。

## 📞 支持

如果您有任何问题，请通过以下方式联系：

- 提交 [GitHub Issue](https://github.com/YaBoom/springboot-dify-integration/issues)
- 发送邮件至: 15007105273@163.com

## 🙏 致谢

- 感谢 [Dify](https://dify.ai/) 提供的优秀AI应用开发平台
- 感谢 [Spring Boot](https://spring.io/projects/spring-boot) 社区
- 感谢 [MyBatis-Plus](https://baomidou.com/) 团队

---

⭐ 如果这个项目对你有帮助，请给一个Star！