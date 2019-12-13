package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends BaseTest{
	HomePage homePage;
	LoginPage loginPage;
	TestUtil testUtil;
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
		 homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
		boolean flag = homePage.verifyUserName();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void clickonContactsLinkTest() throws InterruptedException
	{
		testUtil.switchToFrame();
		homePage.clickOnContactsLink();
		Thread.sleep(3000);
		
	}


	@Test(priority=2)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyTitleOfHomePage();
		Assert.assertEquals(homePageTitle, "CRMPRO","HomePageTitle is not matched");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
