package com.example.demo.Socket.CityRoom;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class CityRoom {
    private String roomId;
    private String name;
    private Set<WebSocketSession> sessions = new HashSet<>();

    public static CityRoom create(String pid){
        CityRoom cityRoom = new CityRoom();
        cityRoom.roomId = pid;
        cityRoom.name = "UUID.randomUUID().toString()";
        return cityRoom;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void handleMessage(WebSocketSession session, ChatMessage chatMessage,
                              ObjectMapper objectMapper) throws IOException {
        send(chatMessage,objectMapper);
    }

    private void send(ChatMessage chatMessage, ObjectMapper objectMapper) throws IOException {
        TextMessage textMessage = new TextMessage(objectMapper.
                writeValueAsString(chatMessage.getMessage()));
        for(WebSocketSession sess : sessions){
            sess.sendMessage(textMessage);
        }
    }
}