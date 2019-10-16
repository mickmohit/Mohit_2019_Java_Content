package com.mohit.AOPdemo.aspect;


import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.mohit.AOPdemo.Account;

@Aspect
@Component
public class MyDemoLoggingAspect {

	private Logger mylooger= Logger.getLogger(getClass().getName());
	
	@Before("execution(public void com.mohit.AOPdemo.dao.AccountDao.addAccount())")
	public void beforeAddAccountAdvice()
	{
		System.out.println("Advice_1 call");
		System.out.println("Executing before add account action");
	}
	
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice_2()
	{
		System.out.println("Advice_2 call");
		System.out.println("Executing before add account action");
	}
	
	@Before("execution(public void add*())")
	public void beforeAddAccountAdvice_3()
	{
		System.out.println("Advice_3 call");
		System.out.println("Executing before add account action");
	}
	
	@Before("execution(void add*())")
	public void beforeAddAccountAdvice_4()
	{
		System.out.println("Advice_4 call");
		System.out.println("Executing before add account action");
	}
	
	@Before("execution(* add*())")
	public void beforeAddAccountAdvice_5()
	{
		System.out.println("Advice_5 call");
		System.out.println("Executing before add account action");
	}
	
	//adding param type Pointcut to JointPont(method)
	//Pointcut==It is an expression language of AOP that matches join points.
	
	@Before("execution(* add*(com.mohit.AOPdemo.Account))")
	public void beforeAddAccountAdvice_6()
	{
		System.out.println("Advice 1 param type call.....>(1)");
		System.out.println("Executing before add account action");
	}
	
	//any number of param to method by using ..(dot dot), 2 dots
	@Before("execution(* add*(com.mohit.AOPdemo.Account, ..))")
	public void beforeAddAccountAdvice_7()
	{
		System.out.println("Advice any no of param type call.....>(Any number)");
		System.out.println("Executing before add account action");
	}
	
	// on any return type, any modifier, any Class, any method and any no. of params
	@Before("execution(* com.mohit.AOPdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice_8()
	{
		System.out.println("Advice for on any return type, any modifier, any Class, any method and any no. of params.....>(Any number)");
		System.out.println("Executing before add account action");
	}
	
	
	//******************Concept of PointCut i.e. multiple pointcut use*******//
	// in below 2 methods we have created a common pointcut expression and 
	//using it at multiple places, this lessens our redo of update of any pointcut
	
	@Pointcut("execution(* com.mohit.AOPdemo.dao.*.*(..))")
	public void forDaoPackage()
	{
	}
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice_9()
	{
		System.out.println("Advice_9 call");
		System.out.println("Executing before add account action with PointCut decalaration");
	}
	
	
	
	// below are way of PointCuts in which you can use multiple 
	//conditional PointCut at oen place
	@Pointcut("execution(* com.mohit.AOPdemo.dao.*.get*(..))")
	public void forgetters()
	{
	}
	@Pointcut("execution(* com.mohit.AOPdemo.dao.*.set*(..))")
	public void forsetters()
	{
	}
	@Pointcut("forDaoPackage() && !(forgetters() || forsetters())")
	public void forNogetterssetters()
	{
	}
	
	@Before("forNogetterssetters()")
	public void beforeAddAccountAdvice_10()
	{
		System.out.println("Advice_10 call");
		System.out.println("Executing before add account action with PointCut decalaration of No Gettes and Setter");
	}
	
	
	//**********************Concept of JoinPoint************************//
	// below is the implement of AOP in which you can actually JoinPoint(method) details
	// like signature and args and use these details
	@Before("forNogetterssetters()")
	public void beforeAddAccountAdvice_11(JoinPoint jointPoint)
	{
		System.out.println("Advice_11 call");
		System.out.println("Executing before add account action with PointCut decalaration of No Gettes and Setter");
		
		//display method signature
		MethodSignature methoSig= (MethodSignature) jointPoint.getSignature(); 
		
		System.out.println("Method:::::::::::::"+ methoSig);
		
		//display method args
		Object[] args=jointPoint.getArgs();
		
		for(Object ar:args)
		{
			System.out.println(ar);
			// again use of method args and check for specific class type and use accordingly
			if(ar instanceof Account)
			{
				Account account= (Account)ar;
				System.out.println("Account Name:==>>>>>"+account.getName());
				System.out.println("Account Level:==>>>>>"+account.getLevel());
			}
		}
	}
	
	
	@Before("forNogetterssetters()")
	public void performAPIAnalytics()
	{
		System.out.println("Advice_12 call");
		System.out.println("Executing API analytics");
	}
	
	
	/// advice type 2: after return advice(success result)
	
	@AfterReturning(pointcut="execution(* com.mohit.AOPdemo.dao.AccountDao.listAccounts(..))",
			returning="result")
	public void afterReturnAdvice(JoinPoint jointPoint, List<Account> result)
	{
		String method= jointPoint.getSignature().toString();
		System.out.println("method in returning advice"+method);
		
		///you can edit the return results with the help of After return type advice
		for(Account account: result)
		{
			String name=account.getName().toUpperCase();
			account.setLevel(name);
		}
		
		System.out.println("result is:===>"+result);
	}
	
	
	/// advice type 3: after throw advice(exception result)
	@AfterThrowing(pointcut="execution(* com.mohit.AOPdemo.dao.AccountDao.*(..))",
			throwing="theEx")
	public void afterThrowAdvice(JoinPoint jointPoint, Throwable theEx)
	{
		String method= jointPoint.getSignature().toShortString();
		System.out.println("method in throwing advice"+method);
		
		System.out.println("Exception throwing from After Throw advice########"+theEx);
	}
	
	
	/// advice type 4: after advice(exception/non exception, more of finally result)
	@After("execution(* com.mohit.AOPdemo.dao.AccountDao.listAccounts(..))")
	public void afteradvice()
	{
		System.out.println("method in after advice");
	}
	
	
	///advice type 5: around advice
	//Important: whenever you run around advice exception will never be thrown to
	//main method, to record this around handle exception you need to use logger info then
	//you will be the details. and to throw to main method use throw ex in catch block of around advice
	@Around("execution(* com.mohit.AOPdemo.dao.AccountDao.listAccounts(..))")
	public Object aroundAdvice(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable
	{
		
		mylooger.info(theProceedingJoinPoint.getSignature().toShortString());
		long begin= System.currentTimeMillis();
		//exceute the target method
		Object result = null;
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			mylooger.warning(e.getMessage());
			//result="No Account found for you (Exception), But move on Ignore it";
			throw e;
		}
		long end= System.currentTimeMillis();
		System.out.println("difference in time"+(end-begin)/1000+"seconds");
		return result;
	}
}
