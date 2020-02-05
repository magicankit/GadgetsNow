
package desktop_tests;

import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
//import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import desktop_pages.Homepage_desktop;
//import pages.Reports;


public class Baseclass_desktop 
{
public WebDriver driver;

//builds a new report using the html template 
	//	ExtentHtmlReporter htmlReporter;
		ExtentReports extent;
		
		//helps to generate the logs in test report.		
  		ExtentTest test;
  	

	@BeforeSuite
	public void beforeSuite()
	{
		// initialize the HtmlReporter
//        htmlReporter = new ExtentHtmlReporter("/users/ankit.arora/Downloads/MAC_Automation/GadgetsNow_Desktop/MyExtentReport.html");
        
      //initialize ExtentReports and attach the HtmlReporter
//        extent = new ExtentReports();
//        extent.attachReporter(htmlReporter);
//        
      //To add system or environment info by using the setSystemInfo method.
//        extent.setSystemInfo("OS", OS);
//        extent.setSystemInfo("Browser", browser);
		
	//	To append to a report you had previously created, simply mark replaceExisting = false and new tests will be appended to the same report.		
		extent = new ExtentReports ("/users/ankit.arora/Downloads/MAC_Automation/GadgetsNow_Desktop/MyExtentReport.html",true);
		extent.loadConfig(new File("/users/ankit.arora/Downloads/MAC_Automation/GadgetsNow_Desktop/extent-config.xml"));
	}
	
	
	@BeforeMethod
	public void beforeMethod(Method method)
	{
	 // starting test	
		test = extent.startTest((this.getClass().getSimpleName()+ " :: " +method.getName()), method.getName());
		test.assignAuthor("Ankit Arora");
		test.assignCategory("Sanity Report - PROD  Desktop");
		// Chrome Capabilities	
				System.setProperty("webdriver.chrome.driver", "/Users/ankit.arora/Downloads/chromedriver");
			//Pass ChromeOptions instance to ChromeDriver Constructor	
				ChromeOptions options = new ChromeOptions();
			//Add chrome switch to disable notification - "--disable-notifications"	
			options.addArguments("--disable-notifications");
			 driver = new ChromeDriver(options);
			 //System.out.println("Browser launched Successfully");
			// step log	 
			 test.log(LogStatus.PASS, "Browser launched Successfully");
	}
	
	@Test
	public  void UrlLaunch() 
	{
	
		// URL launch 
			driver.get("https://www.gadgetsnow.com");
			String currenturl = driver.getCurrentUrl();
			test.log(LogStatus.PASS, "The Current URL of the page is :: " + currenturl);
		//	Reporter.log("GadgetsNow is opened");
		// Maximize screen
			driver.manage().window().maximize();
			test.log(LogStatus.PASS, "The Browser is Maximised ");
			
	}


//
//@Test
//public void popup() throws InterruptedException {
//	Homepage_desktop objectHomePage = new Homepage_desktop(driver);
//	//objectHomePage.Navsize();
//	objectHomePage.H2tags();
//}

@AfterMethod
public void closebrowser() throws InterruptedException
{
	Homepage_desktop objectHomePage = new Homepage_desktop(driver);
	//objectHomePage.Navsize();
	objectHomePage.H2tags();
	driver.close();
	test.log(LogStatus.PASS, "Browser Closed Successfully ");
	// ending test	
	extent.endTest(test);
}
	
@AfterSuite
public void afterSuite()
{
// Once your session is complete and you are ready to write all logs to the report, simply call the flush() method.	
	extent.flush();
	extent.close();
}

}
