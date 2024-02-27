package com.nowon.bullti.chatbot.rabbitmq;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.nowon.bullti.chatbot.komoran.KomoranService;
import com.nowon.bullti.chatbot.movie.MovieApiService;
import com.nowon.bullti.domain.dto.chatbot.AnswerDTO;
import com.nowon.bullti.domain.dto.chatbot.Question;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DynamicRabbitListener {
	
	private final KomoranService komoranService;
	private final SimpMessagingTemplate simpMessagingTemplate;
	private final MovieApiService movieApiService;
	
	public void receiveMessage(String message) {
		System.out.println(">>>>receiveMessage수신된 메세지:"+ message);
//		simpMessagingTemplate.convertAndSend("/topic/order/"+message.getKey(), message);
	}
	
	public void chatbotMessage(Question message) {
		AnswerDTO answer = null;
		
		System.out.println(">>>>chatbotMessage수신된 메세지:"+ message);
		
		try {
			if(message.getContent().contains("영화코드")) {
				answer = AnswerDTO.builder().movieData(movieApiService.getMovieInfo(message.getContent().split(" ")[1])).build();
			}else {
				answer = komoranService.nlpAnalyze(message.getContent()).getAnswer();
			}
			System.out.println( answer.getContent() ); 
		} catch(Exception e) {
			answer = AnswerDTO.builder().content("메세지 오류입니다. 홈으로 돌아갑니다.").build();
			System.out.println("코모란 분석에러: "+e);
		}
		simpMessagingTemplate.convertAndSend("/topic/order/"+message.getKey(), answer);
	}
}