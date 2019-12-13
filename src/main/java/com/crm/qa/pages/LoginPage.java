package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseTest;

public class LoginPage extends BaseTest{
	
	@FindBy(name="username")WebElement username;
	@FindBy(name="password")WebElement password;
	@FindBy(className="img-responsive")WebElement crmLogo;
	@FindBy(xpath="//input[@value='Login']")WebElement loginbtn;
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")WebElement SingnUp;



public LoginPage() {
	PageFactory.initElements(driver, this);
}

public String verifyTitleOfLoginPage() {
	return driver.getTitle();
}

public boolean verifyCRMLogo() {
	return crmLogo.isDisplayed();
}
public HomePage login(String un,String pw) throws InterruptedException {
	username.sendKeys(un);
	password.sendKeys(pw);
	Thread.sleep(2000);
	loginbtn.click();
	
	
	return new HomePage();
}

}