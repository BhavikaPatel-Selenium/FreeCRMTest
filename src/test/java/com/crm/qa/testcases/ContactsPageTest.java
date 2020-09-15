package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactsPageTest extends TestBase {
	

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public ContactsPageTest() {		
		super();
	}
	
	@BeforeTest
	public void setup() {
		intialization();
		loginPage = new LoginPage();
		homePage= new HomePage();
		contactsPage = new ContactsPage();
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage= homePage.clickonContactslink();
	}
	
	@Test(priority=1)
	public void verifycontactpagetitleTest() {
		Assert.assertEquals(contactsPage.verifycontactpagetitle(), "Cogmento CRM", "Contacts us title incorrect");
		
	}
	
	@Test(priority=2)
	public void verifycontactslabelTest() {
		Assert.assertTrue(contactsPage.verifycontactslabel(), "contacts label is missing");
		
	}
	
	@Test(priority=3)
	public void clickOnViewIconTest() {
		contactsPage.clickOnViewIcon("Test 2 Test 2");
		
	}
			
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	

}
