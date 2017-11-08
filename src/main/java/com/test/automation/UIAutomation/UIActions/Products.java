package com.test.automation.UIAutomation.UIActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.test.automation.UIAutomation.testBase.testbase;

public class Products extends testbase {
public static final Logger log = Logger.getLogger(Products.class.getName());



public void clickOnProducts(String products)
{
	driver.findElement(By.xpath(".//a[contains(text(), '"+products+"')]")).click();
	log.info("Clicked on: "+products+" on HomePage");

}
}
