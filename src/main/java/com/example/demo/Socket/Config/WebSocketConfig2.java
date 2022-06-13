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

	@Autowired
	private SocketTextHandler mapHandler;

	@Autowired
	private SocketTextHandler notiHandler;

	@Autowired
	private SocketTextHandler ecocityChatHandler;

	@Autowired
	private SocketTextHandler ecocityMultiHandler;

	@Autowired
	private SocketTextHandler ecocityMapHandler;
	
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(chatHandler, "/chat");
		registry.addHandler(multiHandler, "/multi");
		registry.addHandler(mapHandler, "/map");
		registry.addHandler(notiHandler, "/noti");

		registry.addHandler(ecocityChatHandler, "/ecocity_chat");
		registry.addHandler(ecocityMultiHandler, "/ecocity_multi");
		registry.addHandler(ecocityMapHandler, "/ecocity_map");



	}
}