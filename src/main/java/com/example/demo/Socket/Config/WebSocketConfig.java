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

	@Bean
	public SocketTextHandler mapHandler() {
		return new SocketTextHandler();
	}

	@Bean
	public SocketTextHandler notiHandler() {
		return new SocketTextHandler();
	}

	@Bean
	public SocketTextHandler ecocityChatHandler() {
		return new SocketTextHandler();
	}

	@Bean
	public SocketTextHandler ecocityMultiHandler() {
		return new SocketTextHandler();
	}

	@Bean
	public SocketTextHandler ecocityMapHandler() {
		return new SocketTextHandler();
	}


}