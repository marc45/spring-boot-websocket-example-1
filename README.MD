# Spring Boot WebSocket
> WebSocket为浏览器和服务端提供了双工异步通信的功能, 即浏览器
可以像服务器发送消息，服务器也可以想浏览器发送消息

## Spring Boot 对WebSocket的支持
Spring Boot对内置的Tomcat7或8、 Jetty9和Undertow提供了
WebSocket的支持

## 广播式
广播式：服务端有了消息时，会将消息发给所有连接了当前endpoint的浏览器

## 点对点
聊天室