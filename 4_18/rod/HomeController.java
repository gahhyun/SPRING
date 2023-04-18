package com.earth.rod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


@Controller
public class HomeController {
	
	@Autowired	//의존하는 객체를 자동으로 주입해 주는 어노테이션
	WebApplicationContext servletAC;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {

		ServletContext sc = request.getSession().getServletContext();
		WebApplicationContext rootAC = WebApplicationContextUtils.getWebApplicationContext(sc);
		
		System.out.println("WebApplicationContext = " + rootAC);
		//WebApplicationContext = Root WebApplicationContext, started on Tue Apr 18 10:38:59 KST 2023
		
		System.out.println("servletAC = " + servletAC);
		//servletAC = WebApplicationContext for namespace 'appServlet-servlet', started on Tue Apr 18 10:40:55 KST 2023, parent: Root WebApplicationContext
		
		
		return "home";
	}
	
}
