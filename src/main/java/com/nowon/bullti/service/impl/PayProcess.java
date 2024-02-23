package com.nowon.bullti.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nowon.bullti.domain.dto.payment.PaySaveDTO;
import com.nowon.bullti.domain.entity.order.Order;
import com.nowon.bullti.domain.entity.order.OrderRepository;
import com.nowon.bullti.domain.entity.payment.PaymentRepository;
import com.nowon.bullti.service.PayService;
import com.nowon.bullti.utils.OpenApiUtil;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PayProcess implements PayService{
	
	private final OpenApiUtil apiUtil;
	
	private final PaymentRepository payRepo;
	
	private final OrderRepository orderRepo;
	
	@Value("${portone.api.key}")
	private String key;
	
	@Value("${portone.api.secret}")
	private String secret;
	
	private String hostname = "https://api.iamport.kr";
	
	@Override
	public void prepare(Map<String, Object> body) {
		String token = getToken();
		String url = hostname+"/payments/prepare";
		String methodType = "POST";
		
		Map<String, String> header = new HashMap<>();
		header.put("Content-Type", "application/json");
		header.put("Authorization", "Bearer "+token);
		
		ObjectMapper objectMapper = new ObjectMapper();
				
		String jsonString=null;
		try {
			jsonString = objectMapper.writeValueAsString(body);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		String result=apiUtil.request(url, header, methodType, jsonString);
	}

	@Override
	public String getToken() {
		String url = hostname+"/users/getToken";
		String methodType = "POST";
		Map<String, String> header = new HashMap<>();
		header.put("Content-Type", "application/json");
		
		ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("imp_key", key);
        dataMap.put("imp_secret", secret);

        String jsonString=null;
        try {
            // Map을 JSON 문자열로 변환
        	jsonString = objectMapper.writeValueAsString(dataMap);
            // 변환된 JSON 문자열 출력
            System.out.println("변환된 JSON 문자열 출력 : "+jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
        String result = apiUtil.request(url, header, methodType, jsonString);
        
        // JSON 문자열을 Map으로 변환
        String accessToken=null;
        try {
			Map<String, Object> responseMap = objectMapper.readValue(result, Map.class);
			// 변환된 Map에서 원하는 값 가져오기
            Map<String, Object> tokenInfo = (Map<String, Object>) responseMap.get("response");
            accessToken = (String) tokenInfo.get("access_token");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
        return accessToken;
        
	}

	@Override
	public boolean vaildate(String imp_uid, String merchant_uid) {
		
		//DB랑 portone 정보가 일치하다면 최종결제 완료
		
		//유효하지 않다면 결제취소 및 환불
		
		return true;
	}

	@Transactional
	@Override
	public void save(PaySaveDTO dto) {
		Order order = orderRepo.findById(dto.getOrderNo()).orElseThrow();
		payRepo.save(dto.toEntity(order));
	}

}
