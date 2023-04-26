package com.earth.work.aop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.transaction.annotation.Transactional;

// 핵심기능(메서드)에 공통코드를 추가
class MyClass {
	@Transactional	     //@Transactional이 설정된 핵심기능 메서드에 부가기능을 추가하기
	void ezen1() { 		
		//부가 기능 (공통 기능) before			
		System.out.println("ezen1() 핵심기능 호출");	//핵심기능1  
		//부가 기능 (공통 기능) after
	}
	void ezen2() { 
		//부가 기능 (공통 기능)
		System.out.println("ezen2() 핵심기능 호출"); 	//핵심기능2
		//부가 기능 (공통 기능)
	}
	void itezen1() {
		//부가 기능 (공통 기능)
		System.out.println("itezen1() 핵심기능 호출"); 	//핵심기능3
		//부가 기능 (공통 기능)
	}
}

class MyAdvice {
	
	Pattern p = Pattern.compile("e.*"); //메서드 이름이 e로 시작하는 것만 골라서 적용
	
	boolean matches(Method m) {
		//패턴에 맞는 것만 취해서 그 핵심기능에만 보조기능이 들어가게 함 
		Matcher matcher = p.matcher(m.getName());   
		return matcher.matches();
	}


//	void invoke(Method m, Object obj, Object...args) throws Exception {
//		System.out.println("[before] { ");
//		m.invoke(obj, args);			//ezen1(), ezen2(), itezen1()
//		System.out.println("} [after] ");
//	}
	
	
//	void invoke(Method m, Object obj, Object...args) throws Exception {
//		if(matches(m))
//			System.out.println("[before] { ");
//		m.invoke(obj, args);			//ezen1(), ezen2(), itezen1()
//		if(matches(m))
//			System.out.println("} [after] ");
//	}	
	
	void invoke(Method m, Object obj, Object...args) throws Exception {
		if(m.getAnnotation(Transactional.class) != null)
			System.out.println("[before] { ");
		m.invoke(obj, args);			//ezen1(), ezen2(), itezen1()
		if(m.getAnnotation(Transactional.class) != null)
			System.out.println("} [after] ");
	}	
	
}

public class AopMain {
	
	public static void main(String[] args) throws Exception {
		MyAdvice myAdvice = new MyAdvice();
		Class myClass = Class.forName("com.earth.work.aop.MyClass");
		Object obj = myClass.newInstance();
		
		for(Method m : myClass.getDeclaredMethods()) {
			myAdvice.invoke(m, obj, null);
		}
	}

}








