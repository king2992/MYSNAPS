package com.test.lee.naver.service.impl;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.springframework.stereotype.Component;

import com.test.lee.naver.service.NaverUrl;
import com.test.lee.naver.vo.NaverAuthVO;
/**
 * @className      : NaverUrlImpl
 * @author          : ������
 * @date            : 2021-02-05
 * @description     : ���̹� API ȣ�� URL�� �������� Ŭ���� 
 */
@Component
public class NaverUrlImpl implements NaverUrl {
	
	/**
	 * @methodName      : getNaverLoginUrl
	 * @author          : ������
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : ���̹� �α��� �������� ȣ���ϴ� url�� �������� �޼���
	 */
	public String getNaverLoginUrl() {
		
		SecureRandom random = new SecureRandom();
		String state = new BigInteger(130, random).toString();
		
		StringBuilder sb = new StringBuilder();
		sb.append(NaverAuthVO.getNaverHost());
		sb.append("?response_type=code");
		sb.append("&client_id=" + NaverAuthVO.getClientId());
		sb.append("&redirect_uri=" + NaverAuthVO.getRedirectUri());
		sb.append("&state=" + state);
		
		return sb.toString();
	}
	
	/**
	 * @methodName      : getNaverAccessTokenUrl
	 * @author          : ������
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : ���̹� ������ ��ū�� �߱޹޴� url�� �������� �ɼ���
	 */
	public String getNaverAccessTokenUrl(String code, String state) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(NaverAuthVO.getRequestTokenUrl());
		sb.append("?grant_type=authorization_code");
		sb.append("&client_id=" + NaverAuthVO.getClientId());
		sb.append("&client_secret=" + NaverAuthVO.getClientSecret());
		sb.append("&redirect_uri=" + NaverAuthVO.getRedirectUri());
		sb.append("&code=" + code);
		sb.append("&state=" + state);
		
		return sb.toString();
	}
	
	/**
	 * @methodName      : naverDeleteTokenUrl
	 * @author          : ������
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : īī�� �α��� �������� ȣ���ϴ� �޼���
	 */
	public String naverDeleteTokenUrl(String accessToken) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(NaverAuthVO.getRequestTokenUrl());
		sb.append("?grant_type=delete");
		sb.append("&client_id=" + NaverAuthVO.getClientId());
		sb.append("&client_secret=" + NaverAuthVO.getClientSecret());
		sb.append("&access_token=" + accessToken);
		sb.append("&service_provider=NAVER");
		
		return sb.toString();
	}
}
