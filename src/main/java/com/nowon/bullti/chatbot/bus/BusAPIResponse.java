package com.nowon.bullti.chatbot.bus;

import lombok.Data;

@Data
public class BusAPIResponse<T> {
	
	private ComMsgHeader comMsgHeader;
	private MsgBody<T> msgBody;
	private MsgHeader msgHeader;
}
