package com.earth.satum;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = {"/hello"}, loadOnStartup = 1)
@WebServlet(urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		System.out.println("[HelloServlet] init() 호출");

	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[HelloServlet] service() 호출");
		
		//웹 브라우저에서 전송된 데이터의 인코딩 실행
		request.setCharacterEncoding("utf-8");
		//응답할 데이터 종류가 html임 설정
		response.setContentType("text/html;charset=utf-8");
		
		//출력 스트임PrintWrite 객체
		PrintWriter out = response.getWriter();
		
		//브라우저로 출력할 데이터를 문자열로 연결해서 html태그로 만듦
		String data = "<html>";
		data += "<body>";
		data += "오 마이 서블릿";
		data += "<br/>";
		data += "</body>";
		data += "<html>";
		
		//html태그 문자열을 브라우저로 출력함
		out.println(data);
		
	}

	@Override
	public void destroy() {
		System.out.println("[HelloServlet] destroy() 호출");

	}


	
	

}
