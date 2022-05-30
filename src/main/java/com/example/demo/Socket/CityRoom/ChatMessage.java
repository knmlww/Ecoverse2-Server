package com.example.demo.Socket.CityRoom;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
    private String chatRoomId;
    private String writer;
    private String message;
  //  private MessageType type;


    public String getChatRoomId() {
        return chatRoomId;
    }

    public String getMessage() {
        return message;
    }
}