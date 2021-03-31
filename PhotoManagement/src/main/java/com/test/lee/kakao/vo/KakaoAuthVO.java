package com.test.lee.kakao.vo;
/**
 * @className       : KakaoAuthVO
 * @author          : 이진우
 * @date            : 2021-02-05
 * @description     : 카카오 인증 관련 VO
 */
public class KakaoAuthVO {
	
	final static String KAKAO_HOST = "https://kauth.kakao.com/";
	
	final static String CLIENT_ID = "4fcf0abf3debf14c22e8f32e878073a9";
	
	final static String REDIRECT_URI = "http://localhost:8080/kakao/callback";
	
	final static String REQUEST_TOKEN_URL = "https://kauth.kakao.com/oauth/token";
	
	final static String REQUEST_USERINFO_URL = "https://kapi.kakao.com/v2/user/me";
	
	final static String KAKAO_LOGOUT_URI = "https://kapi.kakao.com/v1/user/logout";
	
	final static String KAKAO_LOGOUT_REDIRECT_URI = "http://localhost:8080/kakao/logout";
	
	String authCode;
	
	String accessToken;
	
	public static String getKakaoHost() {
		return KAKAO_HOST;
	}
	public static String getClientId() {
		return CLIENT_ID;
	}
	public static String getRedirectUri() {
		return REDIRECT_URI;
	}
	public static String getRequestTokenUrl() {
		return REQUEST_TOKEN_URL;
	}
	public static String getRequestUserinfoUrl() {
		return REQUEST_USERINFO_URL;
	}
	public static String getKakaoLogoutUri() {
		return KAKAO_LOGOUT_URI;
	}
	public static String getKakaoLogoutRedirectUri() {
		return KAKAO_LOGOUT_REDIRECT_URI;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
}


