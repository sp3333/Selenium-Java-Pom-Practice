package com.test.automation.UIAutomation.testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.test.automation.UIAutomation.CustomListener.Listener;
import com.test.automation.UIAutomation.CustomListener.WebEventListener;
import com.test.automation.UIAutomation.excelReader.ExcelReader;

public class testbase {
	
	public static final Logger log = Logger.getLogger(testbase.class.getName());

	public static WebDriver driver;
	//public EventFiringWebDriver driver;
	//public WebEventListener eventListener;
	String baseURL = "http://automationpractice.com/index.php";
	String browser  = "firefox";
	Listener lis;
	ExcelReader excel;
	
	/*public EventFiringWebDriver getDriver()
	{
		return driver;
	}
	
	public void setDriver(EventFiringWebDriver driver)
	{
		this.driver = driver;
	}*/
	
	public void init()
	{
        selectBrowser(browser);
		getUrl(baseURL);
		String log4j = "log4j.properties";
		PropertyConfigurator.configure(log4j);
		
	}
	
	public void selectBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","H:\\geckodriver-v0.19.0-win64\\geckodriver.exe ");
	        log.info("Creating the object of "+browser);
			driver = new FirefoxDriver();
			/*driver = new EventFiringWebDriver(dr);
			eventListener = new WebEventListener();
			driver.register(eventListener);*/
			
					
		}
		 if (browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "H:\\geckodriver-v0.17.0-win64\\chromedriver.exe");
			log.info("Creating the object of "+browser);
			driver = new ChromeDriver();
		}
		 if (browser.equalsIgnoreCase("ie"))
			{
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\sp\\Downloads\\IEDriverServer_x64_3.6.0\\IEDriverServer.exe");
				log.info("Creating the object of "+browser);
				driver = new ChromeDriver();
			}
		 if(browser.equalsIgnoreCase("edge"))
		 {
			 System.setProperty("webdriver.edge.driver", "H:\\MicrosoftWebDriver.exe");
				log.info("Creating the object of "+browser);
				driver = new EdgeDriver();
		 }
	
	}
	
	public void getUrl(String url)
	{
		log.info("Navigating to "+url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public String[][] getData(String workbookname, String sheetname)
	{
		
		String path = "H:/JAVA TESTING CODES/UIAutomation/src/main/java/com/test/automation/UIAutomation/data/"+workbookname;
		excel = new ExcelReader(path);
		String[][] data = excel.getDataFromSheet(sheetname, workbookname);
		return data;
	}
	 
	public void waitForElement(int timeOutInSeconds, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));		
	}
	
	public void getScreenshot(String name) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater  = new SimpleDateFormat("dd_MM_yyyy_mm__ss");
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+ "/src/main/java/com/test/automation/UIAutomation/screenshots/";
			File destFile = new File((String) reportDirectory + name +"_" + formater.format(calendar.getTime())+".png");
			FileUtils.copyFile(scrFile, destFile);
			
			//This will help us to link the shot in TestNG report
			Reporter.log("<a href='"+destFile.getAbsolutePath()+"'><img src='"+destFile.getAbsolutePath()+"'height = '100' width = '100'/></a>");
		}
		catch (IOException e){
			e.printStackTrace();
			
		}
	}
	
	public void onTestFailure()
	{
		
	}
}
