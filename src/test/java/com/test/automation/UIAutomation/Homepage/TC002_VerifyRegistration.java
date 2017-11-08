package com.test.automation.UIAutomation.Homepage;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.UIAutomation.UIActions.RegistrationPage;
import com.test.automation.UIAutomation.testBase.testbase;

import junit.framework.Assert;

public class TC002_VerifyRegistration extends testbase {
	
	public static final Logger log = Logger.getLogger(TC002_VerifyRegistration.class.getName());
	RegistrationPage registration;
	@BeforeClass
	public void setUp()
	{
		init();
	}
	
	@Test
	public void Registration()
	{ 
		log.info("==================Starting Test TC002_VerifyRegistration =================");	
		registration = new RegistrationPage(driver); 
		registration.ClicksignIntab();
		// Assert.assertEquals(true,registration.getRegistrationSuccessmessage());
		registration.Registeration("patelshivam3033@yahoo.com","Shivam", "Patel", "thirstywdd","555 Brimorton Drive", "toronto","55869","6476778203");
		log.info("==================Finishing Test TC002_VerifyRegistration =================");	
	  
	}
	@AfterClass
	public void Close()
	{
		//driver.quit();
	}

	
}
