package com.nowon.bullti.chatbot.rabbitmq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ChatbotConfig {

	private final RabbitMQService rabbitMQService;
	
	@Value("${spring.rabbitmq.template.prefixName}")
	private String prefixName;
	@Value("${spring.rabbitmq.template.suffixQueueName}")
	private String suffixQueueName;

	@Value("${spring.rabbitmq.template.mainName}")
	private String mainName;
	
	@PostConstruct
	public void createChatbotQueue() {
		rabbitMQService.createQueue(mainName);
		rabbitMQService.createExchange(mainName);
		rabbitMQService.bindQueueToExchange(mainName);
	}
}

