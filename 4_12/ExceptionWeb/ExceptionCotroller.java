package com.earth.duststorm;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionCotroller {

	@RequestMapping("/ex_")
	public void earth() throws Exception {
		try {
			throw new Exception("예외가 발생했습니다");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/ex_2")
	public String earth2() throws Exception {
		throw new Exception("예외가 발생했습니다2");
	}

	@RequestMapping("/ex_3")
	public String earth3() throws Exception {
		throw new NullPointerException("널포인터 예외가 발생했습니다");
	}

	
	 @ExceptionHandler 
	 public String catchar(Exception ex, Model m) {
		 System.out.println("catchar() in ExceptionCotrollerr");
		 return "error"; 
	 }
	

	@ExceptionHandler({ NullPointerException.class, FileNotFoundException.class })
	public String catchar2(Exception ex, Model m) {
		return "error";
	}

	@RequestMapping("/ex_4")
	public String eart4() throws Exception {
		throw new ArrayIndexOutOfBoundsException("배열 범위를 벗어난 예외");
	}

}
