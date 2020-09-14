package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.utility.WebEventListner;
import com.crm.qa.utility.testUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver eventDriver;
	public static WebEventListner eventListner;
	
	public TestBase(){
	
	try {
	
	prop =new Properties();
	FileInputStream inp= new FileInputStream("D:\\Bhavika\\Eclipse workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
	prop.load(inp);
	
	} catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}	
	
}
public void intialization() {
	String browsername= prop.getProperty("browser");
	if(browsername.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", "D:\\Bhavika\\Softwares\\Chrome Driver\\chromedriver.exe");
		driver= new ChromeDriver();
	} else if(browsername.equals("FF")) {
		System.setProperty("webdriver.gecko.driver", "F:\\Bhavika\\geckodriver.exe");
		driver= new FirefoxDriver();		
	}
	
	eventDriver= new EventFiringWebDriver(driver);
	eventListner= new WebEventListner();
	eventDriver.register(eventListner);
	driver= eventDriver;
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	driver.manage().timeouts().pageLoadTimeout(testUtil.Page_load_timeout, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(testUtil.impilicit_timeout, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));						
	}
	
}
	
	
	


