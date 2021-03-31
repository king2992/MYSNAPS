package com.test.lee.naver.service;
/**
 * @className       : NaverUrlImpl
 * @author          : 이진우
 * @date            : 2021-02-05
 * @description     : 네이버 API 호출 URL을 가져오는 인퍼페이스 
 */
public interface NaverUrl {
	
	/**
	 * @methodName      : getNaverLoginUrl
	 * @author          : 이진우
	 * @date            : 2021-02-05
	 * @description     : 네이버 로그인 페이지를 호출하는 url을 가져오는 메서드
	 */
	public String getNaverLoginUrl();
	
	/**
	 * @methodName      : getNaverAccessTokenUrl
	 * @author          : 이진우
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : 네이버 엑세스 토큰을 발급받는 url을 가져오는 케서드
	 */
	public String getNaverAccessTokenUrl(String code, String state);
	
	/**
	 * @methodName      : naverDeleteTokenUrl
	 * @author          : 이진우
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : 카카오 로그인 페이지를 호출하는 메서드
	 */
	public String naverDeleteTokenUrl(String accessToken);
	
}
