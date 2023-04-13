package com.earth.signin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
public class SigninApplication {

	public static void main(String[] args) {
		SpringApplication.run(SigninApplication.class, args);
	}

	public String hello(){ return  "Hi,SB";}
}
