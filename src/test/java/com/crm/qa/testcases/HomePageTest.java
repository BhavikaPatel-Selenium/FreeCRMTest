package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public HomePageTest() {		
		super();
	}
	
	@BeforeTest
	public void setup() {
		intialization();
		loginPage = new LoginPage();
		homePage= new HomePage();
		contactsPage = new ContactsPage();
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyhomepagetitleTest() {
		String homepagetitle = HomePage.verifyhomepagetitle();
		Assert.assertEquals(homepagetitle, "Cogmento CRM", "Home Page title is not matched");
	}
		
	@Test(priority=2)
	
	public void ValidateUsernameTest() {
		boolean username= homePage.verifyUsername();
		Assert.assertTrue(username);
	
	}
	
	@Test(priority=3)
	
	public void ValidateclickOnContactslinkTest() {
		contactsPage= homePage.clickonContactslink();
	}
	
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
	
	

}
