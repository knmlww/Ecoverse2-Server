package com.example.demo.Socket.Config;

import com.example.demo.Socket.Handler.SocketTextHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig2 implements WebSocketConfigurer {
	@Autowired
	private SocketTextHandler chatHandler;
	
	@Autowired
	private SocketTextHandler multiHandler;
	
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(chatHandler, "/chat");
		registry.addHandler(multiHandler, "/multi");
	}
}