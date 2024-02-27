package com.nowon.bullti.chatbot.bus;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BusServiceProcess implements BusService {

	private final OpenApiUtil2v openApiUtil; // 공공DB 서버로 보냄

	@Value("${data.go.kr.bus.servicekey}")
	private String serviceKey;

	@Value("${kakao.service.key}")
	private String kakaokey;

	@Override
	public ModelAndView stationListProcess(Coords coords) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void busPageProcess(Model model) {
		model.addAttribute("kakaokey", kakaokey);
	}

	@Override
	public ModelAndView stationListProcess(Coords coords, Model model) {

		StringBuilder urlBuilder = new StringBuilder(
				"http://ws.bus.go.kr/api/rest/stationinfo/getStationByPos"); /* URL */

		String latitude = String.valueOf(coords.getLatitude()); // 위도 ->Y
		String longitude = String.valueOf(coords.getLongitude()); // 경도 -> X
		String radius = "300";

		String responseStr = null;
		try {
			urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey); /* Service Key */
			urlBuilder.append(
					"&" + URLEncoder.encode("tmX", "UTF-8") + "=" + URLEncoder.encode(longitude, "UTF-8")); /* 기준위치 X */
			urlBuilder.append(
					"&" + URLEncoder.encode("tmY", "UTF-8") + "=" + URLEncoder.encode(latitude, "UTF-8")); /* 기준위치 Y */
			urlBuilder.append("&" + URLEncoder.encode("radius", "UTF-8") + "="
					+ URLEncoder.encode(radius, "UTF-8")); /* 단위 m(미터) */
			urlBuilder.append("&" + URLEncoder.encode("resultType", "UTF-8") + "="
					+ URLEncoder.encode("json", "UTF-8")); /* [xml, json] */ // 둘중하나
			String apiUrl = urlBuilder.toString();
			// 공공데이터에 요청

			Map<String, String> requestHeaders = new HashMap<>();
			requestHeaders.put("Content-type", "application/json");

			responseStr = openApiUtil.request(apiUrl, requestHeaders, "GET", null);

		} catch (Exception e) {

			e.printStackTrace();
		}

		System.out.println(">>>responseStr:" + responseStr);

		// JSON 형식의 문자열 -> 자바의 객체로 매핑
		ObjectMapper objectMapper = new ObjectMapper(); // json
		BusAPIResponse<StationItem> result = null;
		try {
			result = objectMapper.readValue(responseStr, new TypeReference<BusAPIResponse<StationItem>>() {
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("list", result.getMsgBody().getItemList()).addAttribute("coords", coords);

		return null;
	}

}