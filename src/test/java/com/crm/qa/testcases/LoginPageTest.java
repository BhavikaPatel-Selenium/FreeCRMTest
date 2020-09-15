package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeTest
	public void setup() {
		intialization();
		loginPage =new LoginPage();
	}
	
	@Test(priority=1)
	public void signuplinkTest() {
		
		Boolean signuplinktest= loginPage.checksignuplink();
		Assert.assertTrue(signuplinktest);		
	}
	
	@Test(priority=2)
	public void logintest() {		
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));		
	}
	
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	

}
