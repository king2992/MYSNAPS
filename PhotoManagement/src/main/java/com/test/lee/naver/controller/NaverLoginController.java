package com.test.lee.naver.controller;

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
import com.test.lee.kakao.service.KakaoUrl;
import com.test.lee.naver.service.NaverApi;
import com.test.lee.naver.service.NaverUrl;
import com.test.lee.naver.vo.NaverAuthVO;
/**
 * @className       : NaverLoginController
 * @author          : ������
 * @date            : 2021-02-05
 * @description     : ���̹� �α��� ��Ʈ�ѷ�
 */
@Controller
@RequestMapping("/naver")
public class NaverLoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	NaverApi naverApi;
	
	@Autowired
	NaverUrl naverUrl;
	
	@Autowired
	KakaoUrl kakaoUrl;
	
	/**
	 * @methodName      : callback
	 * @author          : ������
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : ���̹� �α��� ���� �ڵ带 �߱� �޴� redirect �޼��� / �߱� ���� �׼��� �ڵ�� �׼��� ��ū�� �߱� �޴´�
	 */
	@RequestMapping(value = "/callback", method = RequestMethod.GET)
	public String callback(String code, String state, HttpSession session, NaverAuthVO auth) {
		
		String tokenUrl = naverUrl.getNaverAccessTokenUrl(code, state);
		
		auth.setAccessToken(naverApi.getAccessToken(tokenUrl));
		
        HashMap<String, Object> userInfo = naverApi.getUserInfo(auth.getAccessToken());
        
        session.setAttribute("member", "naverMember");
		session.setAttribute("accessToken", auth.getAccessToken());
		session.setAttribute("email",userInfo.get("email"));
		
		logger.info("<NAVER LOGIN>");
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
	 * @description     : ���̹� �α׾ƿ� �޼���
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model, NaverAuthVO auth) {
		
		auth.setAccessToken((String) session.getAttribute("accessToken"));
		
		model.addAttribute("member", null);
		model.addAttribute("kakaoLoginUrl", kakaoUrl.getKakaoLoginUrl());
		model.addAttribute("kakaoLogout", kakaoUrl.getKakaoLogoutUrl());
		model.addAttribute("naverLoginUrl", naverUrl.getNaverLoginUrl());
		
		session.invalidate();
		
		return "redirect:/";
	}
}
