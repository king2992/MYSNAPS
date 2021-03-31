package com.test.lee.kakao.service;

import java.util.HashMap;
/**
 * @interfaceName   : KakaoApi
 * @author          : 이진우
 * @date            : 2021-02-05
 * @description     : 카카오 API 호출 인터페이스
 */
public interface KakaoApi {
	
	/**
	 * @methodName      : getAccessToken
	 * @author          : 이진우
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : 카카오 인증 서버에서 액세스 토큰을 발급 받는 메서드
	 */
	public String getAccessToken (String authorize_code);
	
	/**
	 * @methodName      : getUserInfo
	 * @author          : 이진우
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : 카카오 인증 서버에서 발급 받은 액세스 토큰으로 사용자 정보를 가져오는 메서드
	 */
	public HashMap<String, Object> getUserInfo (String access_Token);
	
}
