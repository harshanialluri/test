package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends BaseTest{
	
	HomePage homePage;
	DealsPage dealsPage;
	LoginPage loginPage;
	String sheetName="Deals";
	TestUtil testUtil;

	public DealsPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		homePage=new HomePage();
		dealsPage=new DealsPage();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1,dataProvider="getCRMTestData")
	public void createNewDealTest(String title,String company,String primaryConatct,String amount) {
		testUtil.switchToFrame();
		homePage.clickonNewDealLink();
		dealsPage.createNewDeal(title, company, primaryConatct, amount);
		
	}
	
	@Test(priority=2)
	public void verifydealsTextTest()
	{
		testUtil.switchToFrame();
		homePage.clickOnDealsPage();
		boolean flag = dealsPage.verifyDealText();
		Assert.assertTrue(flag);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
