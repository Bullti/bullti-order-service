package com.nowon.bullti.chatbot.bus;

import lombok.Data;

@Data
public class ComMsgHeader {
	private String responseTime;          // null
	private String requestMsgID;          // null
	private String responseMsgID;          // null
	private String returnCode;          // null
	private String successYN;          // null
	private String errMsg;          // null
}
