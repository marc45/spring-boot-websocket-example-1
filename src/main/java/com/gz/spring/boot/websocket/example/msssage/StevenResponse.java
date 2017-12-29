package com.gz.spring.boot.websocket.example.msssage;

/**
 * @author xiaozefeng
 */
public class StevenResponse {
    private String responseMessage;

    public StevenResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }


    public String getResponseMessage() {
        return responseMessage;
    }
}
