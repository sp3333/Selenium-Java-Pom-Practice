package com.test.automation.UIAutomation.Homepage;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.UIAutomation.UIActions.HomePage;
import com.test.automation.UIAutomation.testBase.testbase;

public class TC003_VerifyLoginWithDifferentRecords extends testbase {

public static final Logger log = Logger.getLogger(TC003_VerifyLoginWithDifferentRecords.class.getName());
private static final String SECONDS = null;
HomePage homepage;


@DataProvider(name = "logindata")
public String[][] getTestData()
{
String[][] testRecords = getData("TestData.xlsx","Logintestdata");	
return testRecords;
}

@BeforeClass
public void setUp()
{ 
	init();
	
}

@Test(dataProvider = "logindata")
public void TestLogin(String Username, String Password, String runmode)
{
	
	log.info("================Starting VerifyLogin with Different Records===================");
	homepage = new HomePage(driver);
   homepage.loginApplication(Username,Password);
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    log.info("Checking if verification is done");
   
    homepage.VerifyLoginIsSuccessfull();
    getScreenshot("TestLogin__"+Username);
   
    
    log.info("================Ending VerifyLogin with Different Records===================");
}


@AfterTest
public void endTest()
{
	
	 driver.quit();
	 
}

}
