package tests;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;

public class Baseclass 
{
	public WebDriver driver;
	
	@BeforeTest
	public  void UrlLaunch() 
	{
		
		Map<String, String> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceName", "Nexus 5");

		
		

		
	// Chrome Capabilities	
		System.setProperty("webdriver.chrome.driver", "/Users/ankit.arora/Downloads/chromedriver");
	//Pass ChromeOptions instance to ChromeDriver Constructor	
		ChromeOptions options = new ChromeOptions();
		
		options.setExperimentalOption("mobileEmulation", mobileEmulation);
	//Add chrome switch to disable notification - "--disable-notifications"	
		//options.addArguments("--disable-notifications");
		 driver = new ChromeDriver(options);
		// URL launch 
			driver.get("https://www.gadgetsnow.com");
		// Maximize screen
			driver.manage().window().maximize();
	}



@Test
public void popup() throws InterruptedException {
	HomePage objectHomePage = new HomePage(driver);
	//objectHomePage.Navsize();
	objectHomePage.H2tags();
}

@AfterTest
public void closebrowser()
{
	driver.close();
}
}