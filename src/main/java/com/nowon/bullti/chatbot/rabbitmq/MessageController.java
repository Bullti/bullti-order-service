package com.nowon.bullti.chatbot.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import com.nowon.bullti.domain.dto.chatbot.Question;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MessageController {

	private final RabbitTemplate rabbitTemplate;
	
	@Value("${spring.rabbitmq.template.exchange}")
	private String exchange;
	@Value("${spring.rabbitmq.template.routing-key}")
	private String routingKey;
	// /message/
	@MessageMapping("/bot")
	public void bot(Question dto) {
		System.out.println("메세지컨트롤러");
		rabbitTemplate.convertAndSend(exchange,routingKey,dto);
	}
}
