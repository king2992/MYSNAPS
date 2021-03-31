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
 * @author          : ������
 * @date            : 2021-02-05
 * @description     : ���̹� API ȣ�� Ŭ����
 */
@Component
public class NaverApiImpl implements NaverApi {
	
	/**
	 * @methodName      : getAccessToken
	 * @author          : ������
	 * @date            : 2021-02-05
	 * @param           : String tokenUrl
	 * @description     : ���̹� ����� ������ �������� ���� �׼��� ��ū�� �������� �޼���
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
			if (responseCode == 200) { // ���� ȣ��
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // ���� �߻�
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();
			
            //    Gson ���̺귯���� ���Ե� Ŭ������ JSON�Ľ� ��ü ����
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
	 * @author          : ������
	 * @date            : 2021-02-05
	 * @param           : String accessToken
	 * @description     : ���̹� ���� �������� �߱޹��� �׼��� ��ū���� ����� ������ �������� �޼���
	 */
	public HashMap<String, Object> getUserInfo(String accessToken) {
		HashMap<String, Object> userInfo = new HashMap<String, Object>();// ��û�ϴ� Ŭ���̾�Ʈ���� ���� ������ �ٸ� �� �ֱ⿡ HashMapŸ������ ����
		try {
			URL url = new URL(NaverAuthVO.getRequestUserinfoUrl());
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
			
			JsonObject response = element.getAsJsonObject().get("response").getAsJsonObject();

			String email = response.getAsJsonObject().get("email").getAsString();

			userInfo.put("email", email);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return userInfo;
	}
}
