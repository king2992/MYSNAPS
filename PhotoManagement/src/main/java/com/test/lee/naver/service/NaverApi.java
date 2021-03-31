package com.test.lee.naver.service;

import java.util.HashMap;
/**
 * @interfaceName   : NaverApi
 * @author          : 이진우
 * @date            : 2021-02-05
 * @description     : 네이버 API 호출 인터페이스
 */
public interface NaverApi {
	
	/**
	 * @methodName      : getAccessToken
	 * @author          : 이진우
	 * @date            : 2021-02-05
	 * @param           : String tokenUrl
	 * @description     : 네이버 사용자 정보를 가져오기 위한 액세스 토큰을 가져오는 메서드
	 */
	public String getAccessToken (String tokenUrl);
	
	/**
	 * @methodName      : getUserInfo
	 * @author          : 이진우
	 * @date            : 2021-02-05
	 * @param           : String accessToken
	 * @description     : 네이버 인증 서버에서 발급받은 액세스 토큰으로 사용자 정보를 가져오는 메서드
	 */
	public HashMap<String, Object> getUserInfo (String access_Token);
}
