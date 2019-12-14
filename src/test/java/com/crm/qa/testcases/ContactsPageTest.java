package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends BaseTest{
	LoginPage loginPage;
	ContactsPage contactsPage;
	HomePage homePage;
	TestUtil testUtil;
	String sheetName = "Contacts";
	
	public ContactsPageTest() {
		super();
		}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		loginPage=new LoginPage();
		contactsPage=new ContactsPage();
		homePage=new HomePage();
		testUtil=new TestUtil();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		
	}
	

	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1,dataProvider="getCRMTestData")
	public void createNewContactTest(String title,String firstname,String lastname,String company)
	{
	
		
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Siva", "Nagu", "Chalapathi");
		contactsPage.createNewContact(title, firstname, lastname, company);
	}
	
	@Test(priority=2)
	public void verifyContactsTextTest() {
		homePage.clickOnContactsLink();
		boolean flag=contactsPage.verifyContactsText();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void verifyNameLableTest() {
		homePage.clickOnContactsLink();
		boolean flag=contactsPage.verifyNameLable();
		Assert.assertTrue(flag);
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
