package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseTest;

public class HomePage extends BaseTest{
	
	@FindBy(xpath="//td[contains(text(),'User: Vijji Veeru')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//td[contains(text(),'CRMPRO')]")
	WebElement logoText;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
			WebElement newContactLink;
	
	
	@FindBy(xpath="//a[contains(text(),'New Deal')]")WebElement newDealLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		}
	
	public boolean verifyUserName() {
		return userNameLabel.isDisplayed();
	}
		
		public String verifyTitleOfHomePage() {
			return driver.getTitle();
		}
			public ContactsPage clickOnContactsLink() {
				contactsLink.click();
				return new ContactsPage();
			}
		
		public void clickOnNewContactLink() {
			Actions action=new Actions(driver);
	
			action.moveToElement(contactsLink).build().perform();

			newContactLink.click();
					
			
		}
				
		public void clickonNewDealLink() {
			
			Actions action=new Actions(driver);
			action.moveToElement(dealsLink).build().perform();
			newDealLink.click();
		}
		
		public DealsPage clickOnDealsPage() {
			dealsLink.click();
			return new DealsPage();
		}
	}


