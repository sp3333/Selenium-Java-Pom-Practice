package com.test.automation.UIAutomation.UIActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
	
	public static final Logger log = Logger.getLogger(RegistrationPage.class.getName());

	//private static final WebElement WebElement = null;

	WebDriver driver;
	
	@FindBy(xpath = ".//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signIntab;
	
	@FindBy(xpath = ".//*[@id='email_create']")
	WebElement RegistrationEmail;
	
	@FindBy(xpath = ".//*[@id='SubmitCreate']")
	WebElement CreateAccountbutton;
	
	@FindBy(xpath = ".//*[@id='id_gender1']")
	WebElement Mrradiobutton;
	
	@FindBy(xpath = ".//*[@id='id_gender2']")
	WebElement Mrsradiobutton;
	
	@FindBy(xpath = ".//*[@id='customer_firstname']")
	WebElement Firstnametextbox;
	
	@FindBy(xpath = ".//*[@id='customer_lastname']")
	WebElement Lastnametextbox;
	
	@FindBy(xpath = ".//*[@id='email']")
	WebElement CustomerEmailtextbox;
	
	@FindBy(xpath = ".//*[@id='passwd']")
	WebElement Createpasswordtextbox;
	
	
	@FindBy(xpath = ".//*[@id='address1']")
	WebElement Addresstextbox;
	
	@FindBy(xpath = ".//*[@id='city']")
	WebElement Citytextbox;
	
	@FindBy(id = "postcode")
	WebElement Zipcodetextbox;
	
	@FindBy(xpath = ".//*[@id='submitAccount']")
	WebElement Registerbutton;
	
	/*@FindBy(xpath = ".//*[@id='center_column']/p")
	WebElement Registrationmessage;*/
	
	
	@FindBy(xpath = ".//*[@id='phone']")
	WebElement Phonetextbox;
	
	
    @FindBy(xpath = ".//*[@id='id_state']")
	WebElement Statedropdown;
	Select drpdown = new Select(Statedropdown);
	

	
	
	public RegistrationPage(WebDriver driver)
	{
		this.driver  = driver;
		PageFactory.initElements(driver, this);
	}
	public void ClicksignIntab()
	{
		signIntab.click();
		log.info("SignIN Tab is clicked and the object is "+signIntab);
	}
	/*public void selectState()
	{
		drpdown.selectByIndex(2);
		log.info("State is selected and the object is"+drpdown);
	}
	*/
	public void Registeration(String registrationEmail, String Firstname, String Lastname, String password,String Address,String City,String zipcode,String Phonenumber)
	{
		RegistrationEmail.clear();
		RegistrationEmail.sendKeys(registrationEmail);
		log.info("RegistrationEMail is entered and the object is "+RegistrationEmail);
		CreateAccountbutton.click();
		log.info("CreateButton is clicked and the object is "+CreateAccountbutton);
		
		
		Mrradiobutton.isSelected();
		log.info("MR Radiobutton is selected and the object is "+Mrradiobutton);
		
		Firstnametextbox.sendKeys(Firstname);
		log.info("Firstname is entered and the object is "+Firstnametextbox);
		Lastnametextbox.sendKeys(Lastname);
		log.info("LastName is entered and the object is "+Lastnametextbox);
		Createpasswordtextbox.sendKeys(password);
		log.info("Password is created and the object is "+Createpasswordtextbox);
		Addresstextbox.sendKeys(Address);
		log.info("Address is enetred and the object is "+Addresstextbox);
		Citytextbox.sendKeys(City);
		log.info("City name is entered and the object is "+Citytextbox);
	    //selectState();
		drpdown.selectByIndex(3);
		Zipcodetextbox.sendKeys(zipcode);
		log.info("ZipCode is entered and the object is "+Zipcodetextbox);
		Phonetextbox.sendKeys(Phonenumber);
		log.info("Phone number is entered and the object is "+Phonetextbox);
		
		Registerbutton.click();
		log.info("Register button is clicked");
	}
	
	/*public boolean getRegistrationSuccessmessage()
	{
		log.info("Registration message is "+Registrationmessage);
		if(Registrationmessage.isDisplayed());
		{
		return true;
		}
	}*/
	
	
	
	
	
	
	
}
