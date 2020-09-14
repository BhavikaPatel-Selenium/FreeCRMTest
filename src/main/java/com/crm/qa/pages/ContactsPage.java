package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	//Page factory
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactslabel;
	
	//intializing webelements
	public ContactsPage() {		
		PageFactory.initElements(driver, this);		
	}
	
	//Actions or methods
	public String verifycontactpagetitle() {
		return driver.getTitle();		
	}
	
	public boolean verifycontactslabel() {
		return contactslabel.isDisplayed();
		
	}
	
	public void clickOnViewIcon(String name) {			
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		WebElement clickcheckboxbyname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'"+name+"')]/parent::tr//following-sibling::tr//i[@class='unhide icon']")));	
//		clickcheckboxbyname.click();	
		//driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]/parent::tr//following-sibling::tr//i[@class='unhide icon']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement clickcheckboxbyname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'"+name+"')]/parent::tr//following-sibling::tr//i[@class='unhide icon']")));
		clickcheckboxbyname.click();
	}

}
