package com.test.automation.UIAutomation.Homepage;

import org.testng.annotations.Test;

import com.test.automation.UIAutomation.UIActions.HomePage;
import com.test.automation.UIAutomation.testBase.testbase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TC_004_VerifyingWomenLinks extends testbase {
  HomePage homepage;
	@Test
  public void Test() {
      homepage = new HomePage(driver);
	  homepage.clickOnNavigationMenu("Women");
	  homepage.clickOnProducts("Tops");
  }
  @BeforeClass
  public void beforeClass() {
	  init();
  }

  @AfterClass
  public void afterClass() {
  }

}
