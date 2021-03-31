package com.test.lee.kakao.service;

import java.util.HashMap;
/**
 * @interfaceName   : KakaoApi
 * @author          : ������
 * @date            : 2021-02-05
 * @description     : īī�� API ȣ�� �������̽�
 */
public interface KakaoApi {
	
	/**
	 * @methodName      : getAccessToken
	 * @author          : ������
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : īī�� ���� �������� �׼��� ��ū�� �߱� �޴� �޼���
	 */
	public String getAccessToken (String authorize_code);
	
	/**
	 * @methodName      : getUserInfo
	 * @author          : ������
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : īī�� ���� �������� �߱� ���� �׼��� ��ū���� ����� ������ �������� �޼���
	 */
	public HashMap<String, Object> getUserInfo (String access_Token);
	
}
