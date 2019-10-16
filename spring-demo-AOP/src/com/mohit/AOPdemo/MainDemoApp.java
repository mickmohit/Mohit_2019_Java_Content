package com.mohit.AOPdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mohit.AOPdemo.dao.AccountDao;
import com.mohit.AOPdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDao theAccountDao= context.getBean("accountDao",AccountDao.class);
		MembershipDAO theMembershipDAO= context.getBean("membershipDAO",MembershipDAO.class);
		
		theAccountDao.addAccount(new Account(),true);
		theAccountDao.addAccount(new Account());
		theAccountDao.doWork();
		List<Account> accounts=null;
		
		try {
			//make it true to test AfterThrowable advice
		boolean check=true;
		 accounts=theAccountDao.listAccounts(check);
		}
		catch(Exception ex)
		{
			System.out.println("Exception in main program:::"+ex);
		}
		
		//for returning advice
		System.out.println(accounts);
		
		//calling accountDao setter and getter methods
		theAccountDao.setAccountName("HDFC");
		theAccountDao.setServiceCode("12");
		
		theAccountDao.getAccountName();
		theAccountDao.getServiceCode();
		
		theMembershipDAO.addAccount();
		theMembershipDAO.doSLeep();
		
		context.close();
		
	}

}
