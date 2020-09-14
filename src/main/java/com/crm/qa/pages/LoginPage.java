package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Pagefactory or object repository we need to define
	
	@FindBy(name= "email")
	WebElement username;
	
	@FindBy(name= "password")
	WebElement password;
	
	@FindBy(xpath= "//div[@class='ui fluid large blue submit button']")
	WebElement loginbtn;
	
	@FindBy(linkText= "Sign Up")
	WebElement SignUplink;
	
	
	// Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public HomePage login(String un, String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		loginbtn.click();
		return new HomePage();
	}
	
	public boolean checksignuplink() {
		return SignUplink.isDisplayed();
		
	}
}
