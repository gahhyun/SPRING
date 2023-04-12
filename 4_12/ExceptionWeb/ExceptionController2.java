package com.earth.duststorm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController2 {
	
	@RequestMapping("/ex__")
	public String earth2() throws Exception {
		throw new Exception("예외가 발생했습니다1");
	}

}
