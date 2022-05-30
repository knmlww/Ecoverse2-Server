package com.example.demo.Socket.Handler;

import com.example.demo.Socket.CityRoom.ChatMessage;
import com.example.demo.Socket.CityRoom.CityRoom;
import com.example.demo.Socket.CityRoom.CityRoomRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@Component
@RequiredArgsConstructor
public class SocketCityHandler extends TextWebSocketHandler {
    private final CityRoomRepository cityRoomRepository;
    private final ObjectMapper objectMapper;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        //log.info("메세지 전송 = {} : {}",session,message.getPayload());
        String msg = message.getPayload();
        ChatMessage chatMessage = objectMapper.readValue(msg,ChatMessage.class);
        CityRoom cityRoom = cityRoomRepository.findRoomById(chatMessage.getChatRoomId());
        cityRoom.handleMessage(session,chatMessage,objectMapper);
    }

}