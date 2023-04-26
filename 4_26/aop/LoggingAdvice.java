package com.earth.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component	//객체생성
@Aspect		//advice + pointcut
public class LoggingAdvice {
	
	@Around("execution(* com.earth.aop.MyMath.add*(..))")	// pointcut - 부가기능이 적용될 메서드 패턴(위치)
	public Object methodLog(ProceedingJoinPoint pjp) throws Throwable {
		
		long start = System.currentTimeMillis();
		System.out.println(" ");
		System.out.println("<< (start)");
		 
		Object result = pjp.proceed();		//타켓(target)의 핵심기능(메서드)을 다 호출해 준다
		
		System.out.println((System.currentTimeMillis() - start) + "ms");
		System.out.println("핵심기능 결과 result = " + result);
		System.out.println(" (end) >> ");
		System.out.println( " " );
		
		return result;
		
	}

}
