package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.BaseTest;

public class ContactsPage extends BaseTest{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//strong[contains(text(),'Name')]")
	WebElement nameLabel;
	
	
	@FindBy(xpath="//select[@name='title']")
	WebElement title;
	
	@FindBy(id="first_name")WebElement firstName;
	
	@FindBy(id="surname")WebElement lastName;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement companyName;
	
	@FindBy(id="email")WebElement email;

	@FindBy(xpath="//input[@type='submit' and @value='Save']")WebElement saveBtn;
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsText() {
		return contactsLabel.isDisplayed();
	}

	public boolean verifyNameLable() {
		return nameLabel.isDisplayed();
	}
	
	public void createNewContact(String Title,String fname,String lname,String cname) {
		
	
		Select select=new Select(title);
		select.selectByVisibleText(Title);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		companyName.sendKeys(cname);
	
		saveBtn.click();
		
		//Thread.sleep(2000);
		
	}
	
}
