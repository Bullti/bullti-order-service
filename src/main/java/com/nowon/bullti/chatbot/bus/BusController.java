<<<<<<< HEAD
package com.nowon.bullti.chatbot.bus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class BusController {

    @ResponseBody
    @GetMapping("/bus")
    public String MyLocation(HttpServletRequest request) {
        // 클라이언트의 IP 주소 얻기
        String clientIP = getClientIP(request);

        // IP 주소를 좌표로 변환 (예시: 네이버 지도 API 사용)
        String coordinate = getCoordinateFromIP(clientIP);

        // 결과 반환
        return "My location coordinate: " + coordinate;
    }

    private String getClientIP(HttpServletRequest request) {
        String clientIP = request.getHeader("X-Forwarded-For");
        if (clientIP == null || clientIP.length() == 0 || "unknown".equalsIgnoreCase(clientIP)) {
            clientIP = request.getHeader("Proxy-Client-IP");
        }
        if (clientIP == null || clientIP.length() == 0 || "unknown".equalsIgnoreCase(clientIP)) {
            clientIP = request.getHeader("WL-Proxy-Client-IP");
        }
        if (clientIP == null || clientIP.length() == 0 || "unknown".equalsIgnoreCase(clientIP)) {
            clientIP = request.getRemoteAddr();
        }
        return clientIP;
    }

    private String getCoordinateFromIP(String ipAddress) {
        // TODO: 외부 API를 사용하여 IP 주소를 좌표로 변환하는 로직을 추가해야 합니다.
        // 여기에 실제로 사용할 API를 호출하여 좌표를 얻는 코드를 작성하세요.

        // 예시: 네이버 지도 API 호출
        // String apiUrl = "https://navermapsapi.com/convert?ip=" + ipAddress;
        // String coordinate = makeApiRequest(apiUrl);

        // return coordinate;

        return "37.5665,126.9780"; // 임시로 좌표를 반환하는 예시 코드
    }

    private String makeApiRequest(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
=======
package com.nowon.bullti.chatbot.bus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class BusController {

    @ResponseBody
    @GetMapping("/bus")
    public String MyLocation(HttpServletRequest request) {
        // 클라이언트의 IP 주소 얻기
        String clientIP = getClientIP(request);

        // IP 주소를 좌표로 변환 (예시: 네이버 지도 API 사용)
        String coordinate = getCoordinateFromIP(clientIP);

        // 결과 반환
        return "My location coordinate: " + coordinate;
    }

    private String getClientIP(HttpServletRequest request) {
        String clientIP = request.getHeader("X-Forwarded-For");
        if (clientIP == null || clientIP.length() == 0 || "unknown".equalsIgnoreCase(clientIP)) {
            clientIP = request.getHeader("Proxy-Client-IP");
        }
        if (clientIP == null || clientIP.length() == 0 || "unknown".equalsIgnoreCase(clientIP)) {
            clientIP = request.getHeader("WL-Proxy-Client-IP");
        }
        if (clientIP == null || clientIP.length() == 0 || "unknown".equalsIgnoreCase(clientIP)) {
            clientIP = request.getRemoteAddr();
        }
        return clientIP;
    }

    private String getCoordinateFromIP(String ipAddress) {
        // TODO: 외부 API를 사용하여 IP 주소를 좌표로 변환하는 로직을 추가해야 합니다.
        // 여기에 실제로 사용할 API를 호출하여 좌표를 얻는 코드를 작성하세요.

        // 예시: 네이버 지도 API 호출
        // String apiUrl = "https://navermapsapi.com/convert?ip=" + ipAddress;
        // String coordinate = makeApiRequest(apiUrl);

        // return coordinate;

        return "37.5665,126.9780"; // 임시로 좌표를 반환하는 예시 코드
    }

    private String makeApiRequest(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
>>>>>>> refs/remotes/choose_remote_name/master
}