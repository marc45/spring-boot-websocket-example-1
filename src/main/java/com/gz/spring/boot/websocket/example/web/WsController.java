package com.gz.spring.boot.websocket.example.web;

import com.gz.spring.boot.websocket.example.msssage.StevenMessage;
import com.gz.spring.boot.websocket.example.msssage.StevenResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @author xiaozefeng
 */
@Controller
public class WsController {

    /**
     * @MessageMapping 浏览器向服务端发送请求时，映射到/welcome 这个地址
     * @SendTo 当服务端有消息时，会对订阅了@SendTo中的路径的浏览器发送消息
     *
     * @param message
     * @return
     * @throws InterruptedException
     */
    @MessageMapping("welcome")
    @SendTo("/topic/getResponse")
    public StevenResponse say(StevenMessage message) throws InterruptedException {
        Thread.sleep(3000);
        return new StevenResponse("Welcome, " + message.getName() + "!");
    }
}
