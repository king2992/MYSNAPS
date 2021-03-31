package com.test.lee.naver.service;

import java.util.HashMap;
/**
 * @interfaceName   : NaverApi
 * @author          : ������
 * @date            : 2021-02-05
 * @description     : ���̹� API ȣ�� �������̽�
 */
public interface NaverApi {
	
	/**
	 * @methodName      : getAccessToken
	 * @author          : ������
	 * @date            : 2021-02-05
	 * @param           : String tokenUrl
	 * @description     : ���̹� ����� ������ �������� ���� �׼��� ��ū�� �������� �޼���
	 */
	public String getAccessToken (String tokenUrl);
	
	/**
	 * @methodName      : getUserInfo
	 * @author          : ������
	 * @date            : 2021-02-05
	 * @param           : String accessToken
	 * @description     : ���̹� ���� �������� �߱޹��� �׼��� ��ū���� ����� ������ �������� �޼���
	 */
	public HashMap<String, Object> getUserInfo (String access_Token);
}
