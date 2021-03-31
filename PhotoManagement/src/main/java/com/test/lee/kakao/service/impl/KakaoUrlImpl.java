package com.test.lee.kakao.service.impl;

import org.springframework.stereotype.Component;

import com.test.lee.kakao.service.KakaoUrl;
import com.test.lee.kakao.vo.KakaoAuthVO;
/**
 * @className      : KakaoUrlImpl
 * @author          : 이진우
 * @date            : 2021-02-05
 * @description     : 카카오 API 호출 URL을 가져오는 클래스 
 */
@Component
public class KakaoUrlImpl implements KakaoUrl {
	
	/**
	 * @methodName      : getLoginUrl
	 * @author          : 이진우
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : 카카오 로그인 페이지를 호출하는 url을 가져오는 메서드
	 */
	public String getKakaoLoginUrl() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(KakaoAuthVO.getKakaoHost() + "oauth/authorize?");
		sb.append("client_id=" + KakaoAuthVO.getClientId());
		sb.append("&redirect_uri=" + KakaoAuthVO.getRedirectUri());
		sb.append("&response_type=code");
		
		return sb.toString();
	}
	
	/**
	 * @methodName      : getLogoutUrl
	 * @author          : 이진우
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : 카카오 로그아웃 페이지를 호출하는 url을 가져오는 메서드 
	 */
	public String getKakaoLogoutUrl() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(KakaoAuthVO.getKakaoHost() + "oauth/logout?");
		sb.append("client_id=" + KakaoAuthVO.getClientId());
		sb.append("&logout_redirect_uri=" + KakaoAuthVO.getKakaoLogoutRedirectUri());
		
		return sb.toString();
	}
	
	/**
	 * @methodName      : getTokenQueryStringUrl
	 * @author          : 이진우
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : 액세스 토큰을 발급받는 url 쿼리스트링을 가져오는 메서드
	 */
	public String getKakaoTokenQueryStringUrl(String code) {
		
        StringBuilder sb = new StringBuilder();
        sb.append("grant_type=authorization_code");
        sb.append("&client_id=" + KakaoAuthVO.getClientId());
        sb.append("&redirect_uri=" + KakaoAuthVO.getRedirectUri());
        sb.append("&code=" + code);
		
        return sb.toString();
	}
	
}
