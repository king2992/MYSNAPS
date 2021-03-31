package com.test.lee.kakao.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.lee.HomeController;
import com.test.lee.kakao.service.KakaoApi;
import com.test.lee.kakao.service.KakaoUrl;
import com.test.lee.kakao.service.impl.KakaoApiImpl;
import com.test.lee.kakao.service.impl.KakaoUrlImpl;
import com.test.lee.kakao.vo.KakaoAuthVO;
import com.test.lee.naver.service.NaverUrl;
/**
 * @className       : KakaoLoginController
 * @author          : ������
 * @date            : 2021-02-05
 * @description     : īī�� �α��� ��Ʈ�ѷ�
 */
@Controller
@RequestMapping("/kakao")
public class KakaoLoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	KakaoApi kakaoApi;
	
	@Autowired
	KakaoUrl kakaoUrl;
	
	@Autowired
	NaverUrl naverUrl;
	
	/**
	 * @methodName      : callback
	 * @author          : ������
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : īī�� �α��� ���� �ڵ带 �߱� �޴� redirect �޼��� / �߱� ���� �׼��� �ڵ�� �׼��� ��ū�� �߱� �޴´�
	 */
	@RequestMapping(value = "/callback", method = RequestMethod.GET)
	public String callback(String code, HttpSession session, KakaoAuthVO auth) throws IOException{
		
		auth.setAccessToken(kakaoApi.getAccessToken(code));
		
		HashMap<String, Object> userInfo = kakaoApi.getUserInfo(auth.getAccessToken());
		
		session.setAttribute("member", "kakaoMember");
		session.setAttribute("accessToken", auth.getAccessToken());
		session.setAttribute("email", userInfo.get("email"));
		
		logger.info("<KAKAO LOGIN>");
		logger.info("code", code);
		logger.info("accessToken", auth.getAccessToken());
		logger.info("userInfo", userInfo.toString());
		
		return "redirect:/";
	}
	
	/**
	 * @methodName      : logout
	 * @author          : ������
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : īī�� �α׾ƿ� redirect �޼���
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpSession session) {
		
		model.addAttribute("member", null);
		model.addAttribute("kakaoLoginUrl", kakaoUrl.getKakaoLoginUrl());
		model.addAttribute("kakaoLogoutUrl", kakaoUrl.getKakaoLogoutUrl());
		model.addAttribute("naverLoginUrl", naverUrl.getNaverLoginUrl());
		
		session.invalidate();
		
		return "redirect:/";
	}
}
