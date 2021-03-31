package com.test.lee.naver.service.impl;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.test.lee.naver.service.NaverApi;
import com.test.lee.naver.vo.NaverAuthVO;
/**
 * @className       : NaverApiImpl
 * @author          : 이진우
 * @date            : 2021-02-05
 * @description     : 네이버 API 호출 클래스
 */
@Component
public class NaverApiImpl implements NaverApi {
	
	/**
	 * @methodName      : getAccessToken
	 * @author          : 이진우
	 * @date            : 2021-02-05
	 * @param           : String tokenUrl
	 * @description     : 네이버 사용자 정보를 가져오기 위한 액세스 토큰을 가져오는 메서드
	 */
	public String getAccessToken(String tokenUrl) {
		String accessToken = "";
	    URL url;
		try {
			url = new URL(tokenUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;
			System.out.println("responseCode=" + responseCode);
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();
			
            //    Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(res.toString());
            
            accessToken = element.getAsJsonObject().get("access_token").getAsString();
            
            System.out.println("element.toString : "+element.toString());
            
		} catch (IOException e) {
			e.printStackTrace();
		}
		return accessToken;
	}
	
	/**
	 * @methodName      : getUserInfo
	 * @author          : 이진우
	 * @date            : 2021-02-05
	 * @param           : String accessToken
	 * @description     : 네이버 인증 서버에서 발급받은 액세스 토큰으로 사용자 정보를 가져오는 메서드
	 */
	public HashMap<String, Object> getUserInfo(String accessToken) {
		HashMap<String, Object> userInfo = new HashMap<String, Object>();// 요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
		try {
			URL url = new URL(NaverAuthVO.getRequestUserinfoUrl());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Authorization", "Bearer " + accessToken);// 요청에 필요한 Header에 포함될 내용

			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("response body : " + result);

			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
			
			System.out.println("getAsJsonObject : "+element.getAsJsonObject().toString());
			
			JsonObject response = element.getAsJsonObject().get("response").getAsJsonObject();

			String email = response.getAsJsonObject().get("email").getAsString();

			userInfo.put("email", email);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return userInfo;
	}
}
