package com.nowon.bullti.domain.dto.payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class payCompleteDTO {

	private String imp_uid;
	private String merchant_uid;
	private Long orderNo;
}
