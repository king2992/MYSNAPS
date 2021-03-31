package com.test.lee.naver.service.impl;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.springframework.stereotype.Component;

import com.test.lee.naver.service.NaverUrl;
import com.test.lee.naver.vo.NaverAuthVO;
/**
 * @className      : NaverUrlImpl
 * @author          : 이진우
 * @date            : 2021-02-05
 * @description     : 네이버 API 호출 URL을 가져오는 클래스 
 */
@Component
public class NaverUrlImpl implements NaverUrl {
	
	/**
	 * @methodName      : getNaverLoginUrl
	 * @author          : 이진우
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : 네이버 로그인 페이지를 호출하는 url을 가져오는 메서드
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
	 * @author          : 이진우
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : 네이버 엑세스 토큰을 발급받는 url을 가져오는 케서드
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
	 * @author          : 이진우
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : 카카오 로그인 페이지를 호출하는 메서드
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
