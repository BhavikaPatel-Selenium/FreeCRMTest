package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Page factory-OR
	@FindBy(xpath ="//span[@class='user-display']")
	WebElement username;
	
	
	@FindBy(xpath ="//span[contains(text(),'Contacts')]")
	static
	WebElement contactslink;
	
	@FindBy(xpath ="//span[contains(text(),'Deals')]")
	WebElement dealslink;
	
	
	@FindBy(xpath ="//span[contains(text(),'Tasks')]")
	WebElement taskslink;
	
	//initialize page factory
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Methods/Actions
	
	public static String verifyhomepagetitle() {
		return driver.getTitle();
		
	}
	
	public boolean verifyUsername() {
		return	username.isDisplayed();
	}
	
	public ContactsPage clickonContactslink() {
		contactslink.click();	
		return new ContactsPage();
	}
	
	public DealsPage clickonDealslink() {
		dealslink.click();
		return new DealsPage();
	}
	
	public TasksPage clickonTaskslink() {
		taskslink.click();
		return new TasksPage();
	}
	
	
}
	

