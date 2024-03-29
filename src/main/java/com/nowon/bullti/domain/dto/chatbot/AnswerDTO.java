package com.nowon.bullti.domain.dto.chatbot;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AnswerDTO {
	
	private long no;
	private String content;
	private String keyword;//name
	private List<String> choices;
	
	private String movieData;
	private PhoneInfo phone;
	
	public AnswerDTO phone(PhoneInfo phone){
		this.phone=phone;
		return this;
	}

	
	

}