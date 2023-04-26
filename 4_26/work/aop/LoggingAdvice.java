package com.earth.work.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAdvice {

	@Around("execution(* com.earth.work.aop.MyMath.add*(..))")		//pointcut - 부가기능이 적용될 메서드 패턴
	public Object methodLog(ProceedingJoinPoint pjp) throws Throwable {
		
		long start = System.currentTimeMillis();
		System.out.println("");
		System.out.println("<< (start)");
		
		Object result = pjp.proceed();		//target의 메서드 호출 
		
		System.out.println((System.currentTimeMillis() - start) + "ms");
		System.out.println("핵심기능 결과 result = " + result);
		System.out.println("(end) >>");
		System.out.println("");
		
		return result;
		
	}
}
