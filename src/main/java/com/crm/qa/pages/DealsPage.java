package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseTest;

public class DealsPage extends BaseTest {

	@FindBy(id="title")WebElement Title;
	
	@FindBy(xpath="//input[@name='client_lookup']")WebElement Comapany;
	
	@FindBy(xpath="//input[@name='contact_lookup']")WebElement PrimaryContact;
	
	@FindBy(xpath="//input[@id='amount']")WebElement Amount;
	
	@FindBy(xpath="//input[@type='submit' and  @value='Save']")WebElement saveBtn;
	
	@FindBy(xpath="//td[contains(text(),'Deals')]")WebElement dealsText;
	
	public DealsPage() {
		PageFactory.initElements(driver, this);
				
	}
	
	public void createNewDeal(String Ttle,String Cmpany,String contact,String amnt) {
		Title.sendKeys(Ttle);
		Comapany.sendKeys(Cmpany);
		PrimaryContact.sendKeys(contact);
		Amount.sendKeys(amnt);
		saveBtn.click();
		
	}
	
	public boolean verifyDealText() {
		return dealsText.isDisplayed();
	}
	
}
