package com.earth.ai;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.Month;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 * 년, 월, 일 입력하면 해당 요일 알려주는 프로그램을 작성하시오
 * 
 * 1)URL 입력에서 호출을 하면 통켓이 HttpServletRequest 객체를 이용
 * 2)브라우저에서 요청한 정보를 HttpServletRequest 객체에 담아서 자동으로 main()메서드의 매개변수로 넘겨줌
 */
import org.springframework.web.bind.annotation.RequestParam;


@Controller	//1. 원격호출 가능한 프로그램으로 등록(통켓에 인지하도록)
public class DatOfTheWeek2 {
	
	//MyDate 클래스에 매개변수 선언, getter, sertter, 작성해야 함
	@RequestMapping("/getdaymvc2")		//2.URL과 메서드 연결 
	public String main(MyDate date , Model model) {
		
		//1. 유효성 검사
		//만약 조건이 false라면(!부정연산자 사용)
	if(!isValid(date))
			return "dayOfWeekError";		//WEB-INF\views\dayOfWeekError.jsp
		
		//2. 요일 계산		
		char dayOfTheWeek = getDayOfWeek(date);
		
		//3. Model에 작업 결과 저장
		model.addAttribute("mydate",date);
		model.addAttribute("dayOfTheWeek",dayOfTheWeek);
		
		return "dayOfTheWeek2"; 			//WEB-INF\views\dayOfTheWeek.jsp
		//jsp파일(뷰)이 없을때는 @RequestMapping()에서 설정한 url과 동일한 파일을 찾게됨
	}

	private char getDayOfWeek(MyDate date) {
		// TODO Auto-generated method stub
		return getDayOfWeek(date.getYear(), date.getMonth(), date.getDay());
	}

	private boolean isValid(MyDate date) {
		// TODO Auto-generated method stub
		return isValid(date.getYear(), date.getMonth(), date.getDay());
	}

	//getDayOfWeek메서드
	private char getDayOfWeek(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();  	//싱글톤 패턴
		cal.set(year, month-1, day);   			   //날짜 setting (1월이 0이다)
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);			//요일을 리턴 (일요일이 1이다)
		
		/*
		 * "_일월화수목금토".chatAt(1) => 일
		 * "_일월화수목금토".chatAt(2) => 월
		 * "_일월화수목금토".chatAt(3) => 화
		 */
		char dayOfTheWeek = " 일월화수목금토".charAt(dayOfWeek);		//요일을 한국어로 변경
		return dayOfTheWeek;
	}
	//isValid메서드 
	public boolean isValid(int year, int month, int day) {
		if(year == -1 || month == -1  || day==-1)
			return false;
		return (month >=1 && month <=12) && (day >=1 && day <=31);
	}
	@ExceptionHandler
	public String catchar(Exception ex) {
		return "dayOfWeekError";
	}

}

