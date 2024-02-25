package com.nowon.bullti.domain.dto.payment;

import com.nowon.bullti.domain.entity.order.Order;
import com.nowon.bullti.domain.entity.payment.PayMethod;
import com.nowon.bullti.domain.entity.payment.PayState;
import com.nowon.bullti.domain.entity.payment.Payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaySaveDTO {

	private Long orderNo;
	private Long amount;
	private String pg;
	private String merchant_uid;

	public Payment toEntity(Order order) {
		PayMethod method = null;
		if (pg.equals("kakaopay")) {
			method = PayMethod.kakaopay;
		}
		return Payment.builder()
				.no(merchant_uid)
				.totalPrice(amount)
				.method(method)
				.state(PayState.temp)
				.order(order)
				.build();
	}
}
