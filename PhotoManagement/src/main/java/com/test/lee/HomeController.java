package com.test.lee;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.lee.kakao.service.KakaoUrl;
import com.test.lee.naver.service.NaverUrl;

/**
 * @className       : HomeController
 * @author          : ������
 * @date            : 2021-02-05
 * @description     : HomeController
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	 
	@Autowired
	KakaoUrl kakaoUrl;
	
	@Autowired
	NaverUrl naverUrl;
	
	/**
	 * @methodName      : home
	 * @author          : ������
	 * @date            : 2021-02-05
	 * @param           : 
	 * @description     : index �޼���
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		
		model.addAttribute("kakaoLoginUrl", kakaoUrl.getKakaoLoginUrl());
		model.addAttribute("kakaoLogoutUrl", kakaoUrl.getKakaoLogoutUrl());
		model.addAttribute("naverLoginUrl", naverUrl.getNaverLoginUrl());
		model.addAttribute("member", session.getAttribute("member"));
		
		return "home";
	}
	
}
