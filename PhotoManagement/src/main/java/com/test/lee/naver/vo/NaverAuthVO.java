package com.test.lee.naver.vo;
/**
 * @className       : KakaoAuthVO
 * @author          : 이진우
 * @date            : 2021-02-05
 * @description     : 카카오 인증 관련 VO
 */
public class NaverAuthVO {
	
	final static String NAVER_HOST = "https://nid.naver.com/oauth2.0/authorize";
	
	final static String CLIENT_ID = "Y04leYOrIIdcWjaSC2kX";
	
	final static String CLIENT_SECRET = "UIUnsYARip";
	
	final static String REDIRECT_URI = "http://localhost:8080/naver/callback";
	
	final static String SESSION_SATE = "oauth_state";
	
	final static String REQUEST_TOKEN_URL = "https://nid.naver.com/oauth2.0/token";
	
	final static String REQUEST_USERINFO_URL = "https://openapi.naver.com/v1/nid/me";
	
	String accessToken;
	
	public static String getNaverHost() {
		return NAVER_HOST;
	}

	public static String getClientId() {
		return CLIENT_ID;
	}

	public static String getClientSecret() {
		return CLIENT_SECRET;
	}

	public static String getRedirectUri() {
		return REDIRECT_URI;
	}

	public static String getSessionSate() {
		return SESSION_SATE;
	}

	public static String getRequestTokenUrl() {
		return REQUEST_TOKEN_URL;
	}

	public static String getRequestUserinfoUrl() {
		return REQUEST_USERINFO_URL;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
}
