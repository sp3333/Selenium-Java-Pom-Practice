package com.test.automation.UIAutomation.Homepage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.UIAutomation.UIActions.HomePage;
import com.test.automation.UIAutomation.testBase.testbase;

import junit.framework.Assert;

public class TC001_VerifyLoginwithInvalidCredentials extends testbase{

	public static final Logger log = Logger.getLogger(TC001_VerifyLoginwithInvalidCredentials.class.getName());
	HomePage homepage;
	@BeforeTest
	public void setUp()
	{
		init();
	}
	
	@Test
	public void verifyLoginWithInvalidCredentials()
	{
		log.info("=================Starting ==verifyLoginWithInvalidCredentials == Test=========== ");
		homepage = new HomePage(driver);
		homepage.loginApplication("Test@gmail.com", "1235ll");
		Assert.assertEquals(homepage.getInvalidLoginText(),"Authentication Failed");
		log.info("=================Finished ==verifyLoginWithInvalidCredentials == Test=========== ");
	}
	
	
	
	@AfterClass
	public void endTest()
	{
		driver.close();
	}
}
