# spring-security-oauth2-demo
spring-security-oauth2-demo  简单例子

下载完后先执行2份建表sql
oauth_client_details.sql（spring security oauth2默认存储client配置的表）
oauth_user_details.sql  （自定义的用户登录信息表）

curl -X POST --user imooc:imoocsecret http://localhost:8060/oauth/token -H "accept: application/json" -H "content-type: application/x-www-form-urlencoded" -d "grant_type=password&username=USER1&password=123456&scope=all"
