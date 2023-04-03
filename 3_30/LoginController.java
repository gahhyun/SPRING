package com.earth.car;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("loginController")	//생략가능
public class LoginController {
	
	@RequestMapping(value = {"/req/loginForm"}, method = {RequestMethod.GET})
	public ModelAndView longinForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/requestMassage/loginForm");
		return mav;
	}

	
	@RequestMapping(value = "/req/login", method = {RequestMethod.GET, RequestMethod.POST} )
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		
		String requestLine = request.getMethod();		//get 또는 post
		requestLine += " " + request.getRequestURI();	// /sum/requestmessage
		
		String qureyString = request.getQueryString();	// year=2023&month=03&day=27
		requestLine += qureyString == null ? "" :"?" +qureyString;
		requestLine += " " + request.getProtocol();
		
		System.out.println(requestLine);
		
		//request header
		Enumeration<String> e = request.getHeaderNames();
		
		while(e.hasMoreElements()) {
			String name = e.nextElement();	//하나하나의 헤더
			System.out.println(name +" : "+request.getHeader(name));
		}
		
		//request body  == POST일때만 해당, GET은 body가 없음
		final int CONTENT_LENGTH = request.getContentLength();
		System.out.println("content length : " + CONTENT_LENGTH);
		
		if(CONTENT_LENGTH > 0 ) {
			
			
		
			
			try {
				request.setCharacterEncoding("utf-8");
				mav.setViewName("/requestMassage/login");
				
				String userID = request.getParameter("userID");
				String userName = request.getParameter("userName");
				
				mav.addObject("userID", userID);
				mav.addObject("userName", userName);
				
				System.out.println();
				System.out.println("userID = " + userID+ ", userName = "+ userName);
				
			} catch (Exception e1) {e1.printStackTrace();}
		}		
		
		return mav;
	}
}
