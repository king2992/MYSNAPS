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
 * @author          : ������
 * @date            : 2021-02-05
 * @description     : īī�� API ȣ�� Ŭ����
 */
@Component
public class KakaoApiImpl implements KakaoApi{
	
	@Autowired
	KakaoUrl kakaoSb;
	
	/**
	 * @methodName      : getAccessToken
	 * @author          : ������
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : īī�� ���� �������� �׼��� ��ū�� �߱� �޴� �޼���
	 */
    public String getAccessToken (String code) {
        String access_Token = "";
        //String refresh_Token = "";
        
        try {
            URL url = new URL(KakaoAuthVO.getRequestTokenUrl());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);//    POST ��û�� ���� �⺻���� false�� setDoOutput�� true��
            //    POST ��û�� �ʿ�� �䱸�ϴ� �Ķ���� ��Ʈ���� ���� ����
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            bw.write(kakaoSb.getKakaoTokenQueryStringUrl(code));
            bw.flush();
           
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode); //    ��� �ڵ尡 200�̶�� ����
 
            //    ��û�� ���� ���� JSONŸ���� Response �޼��� �о����
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";
            
            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);
            
            //    Gson ���̺귯���� ���Ե� Ŭ������ JSON�Ľ� ��ü ����
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
	 * @author          : ������
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : īī�� ���� �������� �߱� ���� �׼��� ��ū���� ����� ������ �������� �޼���
	 */
	public HashMap<String, Object> getUserInfo(String accessToken) {
		HashMap<String, Object> userInfo = new HashMap<String, Object>();// ��û�ϴ� Ŭ���̾�Ʈ���� ���� ������ �ٸ� �� �ֱ⿡ HashMapŸ������ ����
		try {
			URL url = new URL(KakaoAuthVO.getRequestUserinfoUrl());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Authorization", "Bearer " + accessToken);// ��û�� �ʿ��� Header�� ���Ե� ����

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
