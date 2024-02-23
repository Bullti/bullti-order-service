package com.nowon.bullti.chatbot.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.nowon.bullti.chatbot.komoran.KomoranService;
import com.nowon.bullti.domain.dto.chatbot.AnswerDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DynamicRabbitListener {
	
	private final KomoranService komoranService;
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	public void receiveMessage(Question message) {
		System.out.println(">>>>receiveMessage수신된 메세지:"+ message);
		simpMessagingTemplate.convertAndSend("/topic/order/"+message.getKey(), message);
	}
	
	public void chatbotMessage(Question message) {
		AnswerDTO answer = null;
		
		System.out.println(">>>>chatbotMessage수신된 메세지:"+ message);
		
		try {
			answer = komoranService.nlpAnalyze(message.getContent()).getAnswer();
			System.out.println( answer.getContent() ); 
		} catch(Exception e) {
			answer = AnswerDTO.builder().content("메세지 오류입니다. 홈으로 돌아갑니다.").build();
			System.out.println("코모란 분석에러: "+e);
		}
		simpMessagingTemplate.convertAndSend("/topic/order/"+message.getKey(), answer);
	}
}