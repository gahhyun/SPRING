package com.earth.UIScreenWeb;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UIScreenWeb {
	
	@GetMapping("/login/main")
	public String login() {
		return "index";			//로그인 메인 페이지
	}
	
	@PostMapping("/login/result")
	public String save(User user, Model m) throws UnsupportedEncodingException {
		
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를잘못입력했습니다", "UTF-8");
			return "redirect:/login/main?msg=" + msg;
		}
		return "loginForm";
		
	}



	private boolean isValid(User user) {
		return false;
	}
	
}