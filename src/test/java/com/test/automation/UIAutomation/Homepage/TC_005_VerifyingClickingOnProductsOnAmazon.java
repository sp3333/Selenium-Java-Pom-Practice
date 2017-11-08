package com.test.automation.UIAutomation.Homepage;

import org.testng.annotations.Test;

import com.oracle.tools.packager.Log;
import com.test.automation.UIAutomation.UIActions.HomePage;
import com.test.automation.UIAutomation.testBase.testbase;

import org.testng.annotations.BeforeClass;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;

public class TC_005_VerifyingClickingOnProductsOnAmazon {
	WebElement element;
	 WebDriver driver;
	 
	/* @FindBy(xpath = "//*[@id=\"twotabsearchtextbox\"]")
	 WebElement SearchBox;*/
	
	
	//@Test
  public void Verifying_Clicking_On_Links() {
		method("Careers");
		
		driver.navigate().back();
	  
  }
	@Test 
	public void VerifyingProducts_and_AddToCart()
	{
		WebElement SearchBox = driver.findElement(By.xpath("//*[@id=\\\"twotabsearchtextbox\\\""));
		SearchBox.sendKeys("phones");
		method();
	}
  @BeforeClass
  public void beforeClass() {

	  System.setProperty("webdriver.gecko.driver","H:\\geckodriver-v0.19.0-win64\\geckodriver.exe ");
	  driver = new FirefoxDriver();
	  driver.get("https://www.amazon.ca/");
	  
  }
  public void method(String Links)
  {
	  element = driver.findElement(By.xpath("//a[contains(text(),'"+Links+"')]"));
	  element.click();
	  
  }
  public void method()
  {
	  element = driver.findElement(By.xpath("//*[@id=\"atfResults\"]"));
	  element.click();
	  
  }
  

  @AfterClass
  public void afterClass() {
  }

}
