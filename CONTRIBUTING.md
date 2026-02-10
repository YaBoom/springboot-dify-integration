# 贡献指南 Contributing Guide

感谢您对本项目的关注！我们欢迎并感谢任何形式的贡献。

## 🚀 如何贡献

### 报告问题

如果您发现了 bug 或有功能建议，请通过 [GitHub Issues](https://github.com/YaBoom/springboot-dify-integration/issues) 提交：

1. 使用清晰的标题描述问题
2. 提供详细的复现步骤
3. 附上相关的代码片段或错误日志
4. 标注环境信息（Java版本、Spring Boot版本等）

### 提交代码

1. **Fork 本仓库**
   ```bash
   git clone https://github.com/YOUR_USERNAME/springboot-dify-integration.git
   cd springboot-dify-integration
   ```

2. **创建特性分支**
   ```bash
   git checkout -b feature/your-feature-name
   # 或
   git checkout -b fix/bug-description
   ```

3. **提交更改**
   ```bash
   git add .
   git commit -m "feat: 添加新功能描述"
   # 或
   git commit -m "fix: 修复问题描述"
   ```

4. **推送到您的 Fork**
   ```bash
   git push origin feature/your-feature-name
   ```

5. **创建 Pull Request**
   - 描述清楚做了什么改动
   - 关联相关的 Issue（如果有）
   - 确保代码可以正常编译

## 📋 代码规范

### 提交信息规范

我们使用 [Conventional Commits](https://www.conventionalcommits.org/) 规范：

- `feat:` 新功能
- `fix:` 修复 bug
- `docs:` 文档更新
- `style:` 代码格式（不影响功能）
- `refactor:` 代码重构
- `test:` 测试相关
- `chore:` 构建过程或辅助工具的变动

### Java 代码规范

- 遵循 Google Java Style Guide
- 类名使用 PascalCase
- 方法名和变量名使用 camelCase
- 常量使用 UPPER_SNAKE_CASE
- 添加适当的 JavaDoc 注释

## 🧪 测试

提交 PR 前请确保：

1. 代码可以正常编译：`mvn clean compile`
2. 所有测试通过：`mvn test`
3. 代码风格检查通过：`mvn checkstyle:check`

## 📞 联系我们

如有任何问题，欢迎：
- 在 GitHub Issues 中提问
- 发送邮件至项目维护者

## 📜 许可

通过贡献代码，您同意您的贡献将在 MIT 许可证下发布。

---

再次感谢您的贡献！🎉
