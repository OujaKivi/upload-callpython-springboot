# Springboot简单上传文件，调用python脚本返回结果demo

Springboot上传文件，调用Python进行文件处理，返回_json_结果供查询

## Requirement
- JDK 1.8+
- Maven 3+

## Stack
- Java
- Spring Boot
- FreeMarker
- JavaScript
- Python

## Run
1. mvn快速开启任务`mvn spring-boot:run`。
2. 进入浏览器中输入`localhost:8383`进入上传服务。
3. 按钮点击进行文件选择与上传。
4. 点击“计算”按钮，调用python脚本进行运算。
5. 运算完成后，使用`GET`请求`localhost:8383/query`获取结果。
