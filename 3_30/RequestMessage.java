package com.earth.sum;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestMessage {
	@RequestMapping("/requestmessage")
	public void google(HttpServletRequest request) {
		
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
			byte[] content = new byte[CONTENT_LENGTH];
			
			InputStream in;
			
			try {
				in = request.getInputStream();
				in.read(content, 0, CONTENT_LENGTH);
				
				String userID = request.getParameter("userID");
				String userName = request.getParameter("userName");
				
				System.out.println();
				System.out.println("userID = " + userID+ ", userName = "+ userName);
				
			} catch (IOException e1) {e1.printStackTrace();}
		}
		
	}
	

}
