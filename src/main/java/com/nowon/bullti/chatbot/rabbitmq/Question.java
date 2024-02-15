package com.nowon.bullti.chatbot.rabbitmq;

import lombok.Data;

@Data
public class Question {

	private long key;
	private String name;
	private String content;
}
