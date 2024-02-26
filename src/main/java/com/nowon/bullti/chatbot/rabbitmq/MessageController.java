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
	
	@Value("${spring.rabbitmq.template.prefixName}")
	private String prefixName;

	private final RabbitTemplate rabbitTemplate;
	
	@Value("${spring.rabbitmq.template.exchange}")
	private String exchange;
	@Value("${spring.rabbitmq.template.routing-key}")
	private String routingKey;
	// /message/
	@MessageMapping("/bot")
	public void bot(Question dto) {
		rabbitTemplate.convertAndSend(exchange,routingKey,dto);
	}

	@MessageMapping("/order")
	public void sendOrder(int storeNo) {
		System.out.println("/message/order : 데이터 전송됨 " + storeNo);
		String storeExchange = prefixName + storeNo;
		String storeRoutingKey = storeNo + ".#";

		rabbitTemplate.convertAndSend(storeExchange,storeRoutingKey,"aaa");
	}
}
