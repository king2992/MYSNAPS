package com.test.lee.naver.service;
/**
 * @className       : NaverUrlImpl
 * @author          : ������
 * @date            : 2021-02-05
 * @description     : ���̹� API ȣ�� URL�� �������� �������̽� 
 */
public interface NaverUrl {
	
	/**
	 * @methodName      : getNaverLoginUrl
	 * @author          : ������
	 * @date            : 2021-02-05
	 * @description     : ���̹� �α��� �������� ȣ���ϴ� url�� �������� �޼���
	 */
	public String getNaverLoginUrl();
	
	/**
	 * @methodName      : getNaverAccessTokenUrl
	 * @author          : ������
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : ���̹� ������ ��ū�� �߱޹޴� url�� �������� �ɼ���
	 */
	public String getNaverAccessTokenUrl(String code, String state);
	
	/**
	 * @methodName      : naverDeleteTokenUrl
	 * @author          : ������
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : īī�� �α��� �������� ȣ���ϴ� �޼���
	 */
	public String naverDeleteTokenUrl(String accessToken);
	
}
