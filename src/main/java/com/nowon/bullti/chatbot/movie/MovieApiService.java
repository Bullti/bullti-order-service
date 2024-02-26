package com.nowon.bullti.chatbot.movie;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import kr.or.kobis.kobisopenapi.consumer.rest.KobisOpenAPIRestService;
import kr.or.kobis.kobisopenapi.consumer.rest.exception.OpenAPIFault;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MovieApiService {

	private final KobisOpenAPIRestService kobisOpenAPIRestService;
	private final JsoupService jsoupService;
	
	public String getDailyBoxOffice() throws OpenAPIFault, Exception {
		List<MovieListDTO> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		sb.append("<div class=\"part movie\">\n");
		sb.append("    <p>일별 박스오피스 순위입니다.</p>\n");
		sb.append("    <ul class=\"mvContent\">");
		
		//일별 박스오피스 구하기
		LocalDate day = LocalDate.now().minusDays(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String formattedDate = day.format(formatter);
		
		JSONObject jsonObject = new JSONObject(
				kobisOpenAPIRestService.getDailyBoxOffice(true, formattedDate, null, null, null, null)
				);
		
		JSONArray dailyBoxOfficeList = jsonObject.getJSONObject("boxOfficeResult").getJSONArray("dailyBoxOfficeList");
		
		IntStream.range(0, dailyBoxOfficeList.length()/2).boxed().forEach(i -> {
	            try {
	            	list.add(MovieListDTO.builder()
	            			.rank(dailyBoxOfficeList.getJSONObject(i).getString("rank"))
	            			.movieCd(dailyBoxOfficeList.getJSONObject(i).getString("movieCd"))
	            			.movieNm(dailyBoxOfficeList.getJSONObject(i).getString("movieNm"))
	            			.openDt(dailyBoxOfficeList.getJSONObject(i).getString("openDt"))
	            			.build());
	            } catch (JSONException e) {
	                e.printStackTrace();
	            }
	        });
		
		for(MovieListDTO dto : list) {
			sb.append("<li onclick=\"choiceMovie()\">\n"
					+ "			<div>\n"
					+ "				<span>");
			sb.append(dto.getRank());
			sb.append("</span> <span>위</span>\n"
					+ "			</div>\n"
					+ "			<div>\n"
					+ "				<span>제목 :</span> <span>");
			sb.append(dto.getMovieNm());
			sb.append("</span>\n"
					+ "			</div>\n"
					+ "			<div>\n"
					+ "				<span>개봉일 :</span> <span>");
			sb.append(dto.getOpenDt());
			sb.append("</span>\n"
					+ "			</div>\n"
					+ "			<input type=\"hidden\" value=\"");
			sb.append(dto.getMovieCd());
			sb.append("\">\n"
					+ "		</li>\n\n");
		}
		sb.append("</ul>\n"
				+ "</div>");
		
		return sb.toString();
	}
	
	
	public String getMovieInfo(String movieCd) throws OpenAPIFault, Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("<div class=\"part movie\">\n"
				+ "	<p>영화 정보 입니다.</p>\n"
				+ "	<ul class=\"mvContent\">\n"
				+ "		<li>\n"
				+ "			<div>\n"
				+ "				<span>제목 :</span> <span>");
		
		
		JSONObject jsonObject = new JSONObject(
				kobisOpenAPIRestService.getMovieInfo(true, movieCd)
				);
		
		JSONObject movieInfo = jsonObject.getJSONObject("movieInfoResult").getJSONObject("movieInfo");
		JSONArray genres = movieInfo.getJSONArray("genres");
		
		
		StringBuilder nationesBuilder = new StringBuilder();
		IntStream.range(0, genres.length()).boxed().forEach(i -> {
            try {
            	nationesBuilder.append(genres.getJSONObject(i).getString("genreNm")+" "); // 사극 드라마
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
		 sb.append(movieInfo.getString("movieNm"));
		 sb.append("</span>\n"
		 		+ "			</div>\n"
		 		+ "			<br>\n"
		 		+ "			<div>\n"
		 		+ "				<span>장르 :</span> <span>");
		 sb.append(nationesBuilder.toString());
		 sb.append("</span>\n"
		 		+ "			</div>\n"
		 		+ "			<br>\n"
		 		+ "			<div>\n"
		 		+ "				<span>러닝타임 :</span> <span>");
		 sb.append(movieInfo.getString("movieNm"));
		 sb.append("</span>\n"
		 		+ "			</div>\n"
		 		+ "			<br>\n"
		 		+ "			<div>\n"
		 		+ "				<span>개봉일 :</span> <span>");
		 sb.append(movieInfo.getString("openDt"));
		 sb.append("</span>\n"
		 		+ "			</div>\n"
		 		+ "			<br>\n"
		 		+ "			<img alt=\"poster\" src=\"");
		 sb.append(getMoviePosterUrl(movieInfo.getString("movieNm")));
		 sb.append("\">\n"
		 		+ "		</li>\n"
		 		+ "	</ul>\n"
		 		+ "</div>");
		 return sb.toString();
	}
	
	private String getMoviePosterUrl(String name) {
		return jsoupService.getMoviePoster(name);
	}
}
