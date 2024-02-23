package com.nowon.bullti.service;

import java.util.Map;

import com.nowon.bullti.domain.dto.payment.PaySaveDTO;

public interface PayService {

	void prepare(Map<String, Object> body);

	String getToken();

	boolean vaildate(String imp_uid, String merchant_uid);

	void save(PaySaveDTO dto);
}
