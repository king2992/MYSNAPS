package com.test.lee.kakao.service.impl;

import org.springframework.stereotype.Component;

import com.test.lee.kakao.service.KakaoUrl;
import com.test.lee.kakao.vo.KakaoAuthVO;
/**
 * @className      : KakaoUrlImpl
 * @author          : ������
 * @date            : 2021-02-05
 * @description     : īī�� API ȣ�� URL�� �������� Ŭ���� 
 */
@Component
public class KakaoUrlImpl implements KakaoUrl {
	
	/**
	 * @methodName      : getLoginUrl
	 * @author          : ������
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : īī�� �α��� �������� ȣ���ϴ� url�� �������� �޼���
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
	 * @author          : ������
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : īī�� �α׾ƿ� �������� ȣ���ϴ� url�� �������� �޼��� 
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
	 * @author          : ������
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : �׼��� ��ū�� �߱޹޴� url ������Ʈ���� �������� �޼���
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
