package kr.earth.car;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ThrowingTwoDiceServlet
 */
@WebServlet("/twodiceservlet")
public class ThrowingTwoDiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThrowingTwoDiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	@Override
	public void destroy() {
		System.out.println("[ThrowingTwoDiceServlet] destroy() 호출");
	}


	@Override
	public void init() throws ServletException {
		System.out.println("[ThrowingTwoDiceServlet] init() 호출");
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[HelloServlet] service() 호출");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		//<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>와 같은 의미
		
		//1~6사이의 랜덤으로 숫자 출력
		int id1 = (int)(Math.random()*6 + 1); 
		int id2 = (int)(Math.random()*6 + 1);
		
		PrintWriter out;
		try {
			out = response.getWriter();  //객체생성
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			out.println("<img src='img/dice"+id1+".jpg' />");
			out.println("<img src='img/dice"+id2+".jpg' />");
			out.println("</body>");
			out.println("</html>");
		} catch (IOException e) {e.printStackTrace();}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
