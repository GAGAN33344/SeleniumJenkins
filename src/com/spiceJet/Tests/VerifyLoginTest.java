package com.spiceJet.Tests;

import java.time.Duration;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class VerifyLoginTest {
	
	private WebDriver driver;
	static Logger logger = Logger.getLogger(VerifyLoginTest.class);
	
	@BeforeMethod
	public void setUp() throws Exception{
		BasicConfigurator.configure();// By using Basic Configurator Approach
		//PropertyConfigurator.configure("log4j.properties"); //by using .properties File Approach
		String path = System.getProperty("user.dir");
		System.out.println(path);
	    System.setProperty("webdriver.chrome.driver", path + "\\Drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.spicejet.com/");
	    //logger.info("Opening SpiceJet Application");
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); //change wait mechanism in Selenium 4
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //change wait mechanism in Selenium 4
	}
	
	@Test
	public void validateLoginPage() throws Exception{
		String expectedSpiceJetTitle = driver.getTitle();
		//logger.info(spiceJetTitle);
		System.out.println(expectedSpiceJetTitle);
		
		String actualSpiceJetTitle = "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets";
		
		Assert.assertEquals(actualSpiceJetTitle, expectedSpiceJetTitle);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
