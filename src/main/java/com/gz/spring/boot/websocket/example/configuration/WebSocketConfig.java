package com.gz.spring.boot.websocket.example.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/** 配置WebSocket
 * @EnableWebSocketMessageBroker 开启使用 STOMP 协议来传输基于代理 message broker 的消息
 * @author xiaozefeng
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 注册一个STOMP 的 endpoint 并支持SockJS协议
        registry.addEndpoint("endpointSteven").withSockJS();
    }

    /**
     * 配置消息代理
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 广播式配置一个/topic消息代理
        registry.enableSimpleBroker("/topic");
    }
}
