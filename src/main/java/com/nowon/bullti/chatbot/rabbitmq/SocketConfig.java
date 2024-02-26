package com.nowon.bullti.chatbot.rabbitmq;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSocketMessageBroker
public class SocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		//챗봇 웹소켓 연결
		registry.addEndpoint("/green-bot").withSockJS();
		//가맹점 주문 소켓연결
		registry.addEndpoint("/store-order").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		//사용자->서버 메세지를 전송할때
		registry.setApplicationDestinationPrefixes("/message");
	}

	
}
