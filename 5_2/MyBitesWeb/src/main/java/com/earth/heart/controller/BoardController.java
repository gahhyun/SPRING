package com.earth.heart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.earth.heart.domain.SearchItem;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@GetMapping("/list")
	public String list(SearchItem sc,
						Model m,
						HttpServletRequest request) {
		
		if(!loginCheck(request))
			return "redirect:/login/login?toURL=" + request.getRequestURL();
		
		//
		
		
		
		return "boardList";
		
	}

	private boolean loginCheck(HttpServletRequest request) {
		//1. 세션을 얻어서 (false는 session이 없어도 새로 생성하지 않음, 반환값은 null)
		HttpSession session = request.getSession(false);
		//2. 세션에 id가 있는지 확인, 있으면 true를 반환 없으면 false반환
		return session != null && session.getAttribute("id")!=null;
	}

}
