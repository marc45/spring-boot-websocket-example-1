package com.gz.spring.boot.websocket.example.web;

import com.gz.spring.boot.websocket.example.msssage.StevenMessage;
import com.gz.spring.boot.websocket.example.msssage.StevenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @author xiaozefeng
 */
@Controller
public class WsController {
    @Autowired
    private SimpMessageSendingOperations simpMessageSendingOperations;

    /**
     * @MessageMapping 浏览器向服务端发送请求时，映射到/welcome 这个地址
     * @SendTo 当服务端有消息时，会对订阅了@SendTo中的路径的浏览器发送消息
     *
     * @param message
     * @return
     * @throws InterruptedException
     */
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public StevenResponse say(StevenMessage message) throws InterruptedException {
        Thread.sleep(3000);
        return new StevenResponse("Welcome, " + message.getName() + "!");
    }

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) {
        if (principal.getName().equals("wyf")) {
            simpMessageSendingOperations.convertAndSendToUser("wisely",
                    "/queue/notifications",
                    principal.getName() + "-send:" + msg);
        } else {
            simpMessageSendingOperations.convertAndSendToUser("wyf", "/queue/notifications", principal.getName() + "-send:" + msg);
        }
    }


}
