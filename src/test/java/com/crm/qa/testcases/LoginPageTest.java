package com.crm.qa.testcases;

import org.testng.annotations.Test;

import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTest extends BaseTest{
	
	LoginPage loginPage;
	HomePage homePage;
	
	
	
	public LoginPageTest() {
		super();
	}
	

  @BeforeMethod
  public void setUp() {
	  initialization();
	  loginPage=new LoginPage();
	  homePage=new HomePage();
  }
  
  @Test(priority=1)
  public void loginPageTitleTest() {
	  String title=loginPage.verifyTitleOfLoginPage();
	  Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
  }
  
  @Test(priority=2)
  public void crmLogotest() {
	  boolean flag=loginPage.verifyCRMLogo();
	  Assert.assertTrue(flag);
  }
  
  @Test(priority=3)
  public void LoginTest() throws InterruptedException {
	  homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	  
  }

  @AfterMethod
  public void teardown() {
	  driver.quit();
  }
  

}
