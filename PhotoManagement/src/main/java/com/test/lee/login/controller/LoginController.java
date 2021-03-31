/**
 * 
 */
package com.test.lee.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.lee.kakao.service.KakaoUrl;
import com.test.lee.naver.service.NaverUrl;

/**
 * @className       : LoginController
 * @author          : LEE-JIN-WOO
 * @date            : 2021-03-06
 * @description     : 
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	KakaoUrl kakaoUrl;
	
	@Autowired
	NaverUrl naverUrl;
	
	/**
	 * @methodName      : login
	 * @author          : LEE-JIN-WOO
	 * @date            : 2021-03-06
	 * @param           : 
	 * @description     : 
	 */
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("kakaoLoginUrl", kakaoUrl.getKakaoLoginUrl());
		model.addAttribute("naverLoginUrl", naverUrl.getNaverLoginUrl());
		return "login";
	}
}
