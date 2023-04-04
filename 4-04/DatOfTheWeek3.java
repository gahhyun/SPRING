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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 * 년, 월, 일 입력하면 해당 요일 알려주는 프로그램을 작성하시오
 * 
 * 1)URL 입력에서 호출을 하면 통켓이 HttpServletRequest 객체를 이용
 * 2)브라우저에서 요청한 정보를 HttpServletRequest 객체에 담아서 자동으로 main()메서드의 매개변수로 넘겨줌
 */
import org.springframework.web.bind.annotation.RequestParam;

/*
 * 컨트롤러 매개변수
 * 	1) 기본형, String일 때는 @RequestParam이 생략된 것
 * 	2) 참조형일 경우에는 @ModelAttribute
 */

@Controller	
public class DatOfTheWeek3 {
	

	@RequestMapping("/getdaymvc3")		 
	public String main(@ModelAttribute("myDate") MyDate date , Model model) {
		
		
	if(!isValid(date))
			return "dayOfWeekError";		
		
		//2. 요일 계산		
//		char dayOfTheWeek = getDayOfWeek(date);
		
		//3. Model에 작업 결과 저장
//		model.addAttribute("mydate",date);
//		model.addAttribute("dayOfTheWeek",dayOfTheWeek);
		
		return "dayOfTheWeek2"; 			
	
	}

	private @ModelAttribute("dayOfTheWeek") char getDayOfWeek(MyDate date) {

		return getDayOfWeek(date.getYear(), date.getMonth(), date.getDay());
	}

	private boolean isValid(MyDate date) {

		return isValid(date.getYear(), date.getMonth(), date.getDay());
	}

	//getDayOfWeek메서드
	private char getDayOfWeek(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();  	
		cal.set(year, month-1, day);   			  
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);		
	
		char dayOfTheWeek = " 일월화수목금토".charAt(dayOfWeek);		
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

