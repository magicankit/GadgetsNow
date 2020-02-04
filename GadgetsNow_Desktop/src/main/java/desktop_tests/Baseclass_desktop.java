package desktop_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import desktop_pages.Homepage_desktop;


public class Baseclass_desktop 
{
public WebDriver driver;
	
	@BeforeTest
	public  void UrlLaunch() 
	{
	// Chrome Capabilities	
		System.setProperty("webdriver.chrome.driver", "/Users/ankit.arora/Downloads/chromedriver");
	//Pass ChromeOptions instance to ChromeDriver Constructor	
		ChromeOptions options = new ChromeOptions();
	//Add chrome switch to disable notification - "--disable-notifications"	
	options.addArguments("--disable-notifications");
	 driver = new ChromeDriver(options);
	 Reporter.log("The Browser is opened");
		// URL launch 
			driver.get("https://www.gadgetsnow.com");
			Reporter.log("GadgetsNow is opened");
		// Maximize screen
			driver.manage().window().maximize();
			Reporter.log("The Browser is Maximised");
	}



@Test
public void popup() throws InterruptedException {
	Homepage_desktop objectHomePage = new Homepage_desktop(driver);
	//objectHomePage.Navsize();
	objectHomePage.H2tags();
}

@AfterTest
public void closebrowser()
{
	driver.close();
	Reporter.log("Application closed");
}

}
