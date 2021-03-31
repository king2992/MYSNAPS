package com.test.lee.kakao.service;
/**
 * @interfaceName   : KakaoUrl
 * @author          : ������
 * @date            : 2021-02-05
 * @description     : īī�� API ȣ�� URL�� �������� �������̽� 
 */
public interface KakaoUrl {

	/**
	 * @methodName      : getLoginUrl
	 * @author          : ������
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : īī�� �α��� �������� ȣ���ϴ� url�� �������� �޼���
	 */
	public String getKakaoLoginUrl();
	
	/**
	 * @methodName      : getLogoutUrl
	 * @author          : ������
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : īī�� �α׾ƿ� �������� ȣ���ϴ� url�� �������� �޼��� 
	 */
	public String getKakaoLogoutUrl();
	
	/**
	 * @methodName      : getTokenQueryStringUrl
	 * @author          : ������
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : �׼��� ��ū�� �߱޹޴� url ������Ʈ���� �������� �޼���
	 */
	public String getKakaoTokenQueryStringUrl(String code);
}
