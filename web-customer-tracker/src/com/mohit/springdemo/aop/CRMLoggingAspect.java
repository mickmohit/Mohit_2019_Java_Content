package com.mohit.springdemo.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.mohit.springdemo.controller.*.*(..))")
	public void forControllerPackage() {}
	
	@Pointcut("execution(* com.mohit.springdemo.service.*.*(..))")
	public void forServicePackage() {}
	
	@Pointcut("execution(* com.mohit.springdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	
	@Pointcut("forControllerPackage()||forServicePackage()||forDaoPackage()")
	public void appFlow() {}
	
	@Before("appFlow()")
	public void before(JoinPoint theJoinPoint)
	{
		String methdName= theJoinPoint.getSignature().toString();
		myLogger.info("In @Before Advice Method=====>"+methdName);
		
		Object[] ob= theJoinPoint.getArgs();
		
		for(Object temp:ob)
		{
			myLogger.info("===> Arguments"+temp);
		}
		
	}
	
	
	@AfterReturning(pointcut="appFlow()",
			returning="theResult")
	public void afterReturningAdvice(JoinPoint theJoinPoint, Object theResult)
	{
		String methdName= theJoinPoint.getSignature().toString();
		myLogger.info("In @After Returning Advice Method=====>"+methdName);
		
		myLogger.info("Display the Result"+theResult);
	}
	
}
