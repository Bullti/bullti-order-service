package com.nowon.bullti.chatbot.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import com.nowon.bullti.domain.dto.chatbot.Question;
import com.nowon.bullti.domain.dto.store.OrderMessage;

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
	public void sendOrder(OrderMessage dto) {
		System.out.println("/message/order : 데이터 전송됨 " + dto.getStoreNo());
		String storeExchange = prefixName + dto.getStoreNo();
		String storeRoutingKey = dto.getStoreNo() + ".#";

		rabbitTemplate.convertAndSend(storeExchange,storeRoutingKey,"aaa");
	}
}
