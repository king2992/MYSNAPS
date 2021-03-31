/**
 * 
 */
package com.test.lee.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.lee.kakao.service.KakaoUrl;
import com.test.lee.naver.service.NaverUrl;

/**
 * @author LEEJINWOO
 *
 */
@Controller
public class RepoController {
	
	@Autowired
	KakaoUrl kakaoUrl;
	
	@Autowired
	NaverUrl naverUrl;
	
	@RequestMapping(value="/myRepo", method=RequestMethod.GET)
	public String repo(Model model) {
		model.addAttribute("kakaoLoginUrl", kakaoUrl.getKakaoLoginUrl());
		model.addAttribute("naverLoginUrl", naverUrl.getNaverLoginUrl());
		return "repo";
	}
}
