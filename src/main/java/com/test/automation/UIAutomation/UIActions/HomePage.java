package com.test.automation.UIAutomation.UIActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.UIAutomation.Homepage.TC001_VerifyLoginwithInvalidCredentials;
import com.test.automation.UIAutomation.testBase.testbase;

public class HomePage extends testbase {

	public static final Logger log= Logger.getLogger(HomePage.class.getName());
	WebDriver driver;
	@FindBy(xpath = ".//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signIntab;
	
	@FindBy(xpath = ".//*[@id='email']")
	WebElement Emailtextbox;
	
	@FindBy(xpath = ".//*[@id='passwd']")
	WebElement Passwordtextbox;
	
	@FindBy(xpath = ".//*[@id='SubmitLogin']")
	WebElement signInbutton;
	
	@FindBy(xpath = ".//*[@id='center_column']/div[1]/ol/li")
	WebElement authenticationFailedmessage;
	
	@FindBy(xpath = ".//*[@id='header']/div[2]/div/div/nav/div[2]/a")
	WebElement logout;

public void loginApplication(String emailAddress, String Password)
{
	
	signIntab.click();
	log.info("Clicked on signIn and object is "+signIntab.toString());
	Emailtextbox.sendKeys(emailAddress);
	log.info("Entered Email Address:- "+emailAddress+" and the object is "+Emailtextbox.toString());
	Passwordtextbox.sendKeys(Password);;
	log.info("Entered Password:- "+Password+" and the object is "+Passwordtextbox.toString());
	
	signInbutton.click();
	log.info("Clicked on SignIn Button and the object is " +signInbutton.toString());
	
}
public void VerifyLoginIsSuccessfull()
{
	
	if(logout.isDisplayed())
	{
		logout.click();
	}
	
}
public void ClickLogout()
{
	
	logout.click();
	log.info("Clicked on logout button");
	
}
public HomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public String getInvalidLoginText()
{
	log.info("error message is:-"+ authenticationFailedmessage.getText());
	return authenticationFailedmessage.getText();
	
}

public void clickOnNavigationMenu(String menuName)
{
	driver.findElement(By.xpath(".//button[contains(text(), 'Shop now !')]")).click();
	/*WebElement Nmenu = driver.findElement(By.xpath(".//a[@title = '"+menuName+"']"));
	Nmenu.click();
    log.info("Clicked on: "+menuName+" navigation menu");*/
}

public void clickOnProducts(String products)
{
	//*[@id="homefeatured"]/li[2]/div/div[2]/h5/a
	driver.findElement(By.xpath(".//a[contains(text(), '"+products+"')]")).click();
	driver.findElement(By.xpath(".//a[contains(text(), '"+products+"')]")).click();
	log.info("Clicked on: "+products+" on HomePage");

}
	
	
}
