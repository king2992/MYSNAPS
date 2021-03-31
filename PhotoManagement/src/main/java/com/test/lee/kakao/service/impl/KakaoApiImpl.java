package com.test.lee.kakao.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.test.lee.kakao.service.KakaoApi;
import com.test.lee.kakao.service.KakaoUrl;
import com.test.lee.kakao.vo.KakaoAuthVO;
/**
 * @className       : KakaoApiImpl
 * @author          : 이진우
 * @date            : 2021-02-05
 * @description     : 카카오 API 호출 클래스
 */
@Component
public class KakaoApiImpl implements KakaoApi{
	
	@Autowired
	KakaoUrl kakaoSb;
	
	/**
	 * @methodName      : getAccessToken
	 * @author          : 이진우
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : 카카오 인증 서버에서 액세스 토큰을 발급 받는 메서드
	 */
    public String getAccessToken (String code) {
        String access_Token = "";
        //String refresh_Token = "";
        
        try {
            URL url = new URL(KakaoAuthVO.getRequestTokenUrl());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);//    POST 요청을 위해 기본값이 false인 setDoOutput을 true로
            //    POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            bw.write(kakaoSb.getKakaoTokenQueryStringUrl(code));
            bw.flush();
           
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode); //    결과 코드가 200이라면 성공
 
            //    요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";
            
            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);
            
            //    Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);
            
            access_Token = element.getAsJsonObject().get("access_token").getAsString();
            //refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();
            
            System.out.println("access_token : " + access_Token);
            
            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
        return access_Token;
    }
    
	/**
	 * @methodName      : getUserInfo
	 * @author          : 이진우
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : 카카오 인증 서버에서 발급 받은 액세스 토큰으로 사용자 정보를 가져오는 메서드
	 */
	public HashMap<String, Object> getUserInfo(String accessToken) {
		HashMap<String, Object> userInfo = new HashMap<String, Object>();// 요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
		try {
			URL url = new URL(KakaoAuthVO.getRequestUserinfoUrl());
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
			
			//JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
			JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

			//String nickname = properties.getAsJsonObject().get("nickname").getAsString();
			String email = kakao_account.getAsJsonObject().get("email").getAsString();

			userInfo.put("email", email);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return userInfo;
	}

}
