package com.nowon.bullti.chatbot.bus;

import lombok.Data;

@Data
public class MsgHeader {
	private String headerMsg;          // "정상적으로 처리되었습니다."
	private String headerCd;          // "0"
	private int itemCount;          // 0

}
