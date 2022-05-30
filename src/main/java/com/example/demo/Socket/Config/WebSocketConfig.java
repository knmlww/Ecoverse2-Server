package com.example.demo.Socket.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.demo.Socket.Handler.SocketTextHandler;

@Configuration
public class WebSocketConfig {
	@Bean
	public SocketTextHandler chatHandler() {
		return new SocketTextHandler();
	}
	
	@Bean
	public SocketTextHandler multiHandler() {
		return new SocketTextHandler();
	}


}