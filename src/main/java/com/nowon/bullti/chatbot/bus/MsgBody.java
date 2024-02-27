package com.nowon.bullti.chatbot.bus;

import java.util.List;

import lombok.Data;

@Data
public class MsgBody<T> {
	private List<T> itemList;
}
