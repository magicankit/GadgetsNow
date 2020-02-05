package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Reports 
{
	// X-Path of Main Navigation
				static String LINKS_START_XPATH = ".//*[@id='navigation']/div/ul/li[";
				static String LINKS_END_XPATH = "]/a";
				// X-Path of Sub-Menu Navigation	
				static String LINKS_L2_Navigation = "]/div[@class='dropdown clearfix']/div/div/ul[@class='level-two']/li[";
				static String LINKS_L2_Navigation_END = "]";
				static String LINKS_END_L2_Navigation = "]/div[@class='dropdown clearfix']/div/div/ul[@class='level-two']/li";
				
				
				
				//Declaring WebDriver
						WebDriver driver;
						int i,j,k;
						
					// Constructor	
						public Reports (WebDriver driver)
						{
							this.driver = driver;
						}
						
						
						// Size determine and Print Navigation elements
						
						 public void Navsize() throws InterruptedException
						 {
							 /*System.out.println("Finding Size of Navigation");*/
							 //// Finding Size of Navigation
							 int size=driver.findElements(By.xpath(".//*[@id='navigation']/div/ul/li")).size();
							 
								System.out.println("Size of Main Menu are --- "+ size);
								for (int i=4;i<=size;i++)
								{
									//String text = driver.findElement(By.xpath(LINKS_START_XPATH+i+LINKS_END_XPATH)).getText();
									 WebElement element = driver.findElement(By.xpath(LINKS_START_XPATH+i+LINKS_END_XPATH));
									
									System.out.println("Main Menu--"+element.getText());
									
													
									//WebElement size_L3=(WebElement) driver.findElement(By.xpath(".//*[@id='navigation']/div/ul/li[i]/div[@class='dropdown clearfix']/div/div/ul[@class='level-two']/li"));
									//System.out.println("Size of child are --- "+ size_L3);

									//Create object 'action' of an Actions class
									Actions action = new Actions(driver);
									//Mousehover on an element
									action.moveToElement(element).perform();
									Thread.sleep(1000);
									int size_L3=driver.findElements(By.xpath(LINKS_START_XPATH+ i +LINKS_END_L2_Navigation)).size();
									System.out.println("Size of Sub-Menu are --- "+ size_L3);
									/*Log.info("Sub-Menu found");*/
									
									for(int j=1;j<=size_L3;j++)
									{	
										
										//System.out.println(LINKS_START_XPATH+i+LINKS_L2_Navigation +j+LINKS_END_XPATH);
										WebElement subelement = driver.findElement(By.xpath(LINKS_START_XPATH+i+LINKS_L2_Navigation +j+LINKS_END_XPATH));
										/*System.out.println("*****"+subelement.getTagName());*/
										System.out.println("*****"+subelement.getText());
										/*Log.info("Subelement found");*/
									}
									//System.out.println(text + i);
									//Thread.sleep(10000);
									WebElement nav = driver.findElement(By.xpath(LINKS_START_XPATH+i+LINKS_END_XPATH));
									nav.getText();
									nav.click();
									//driver.findElement(By.xpath(LINKS_START_XPATH+i+LINKS_END_XPATH)).click();
									//String browserTitle = driver.getTitle();
									//System.out.println(browserTitle);
									driver.navigate().back();
									Thread.sleep(1000);
														
								}
						 }
						 
						 
						public void H2tags () throws InterruptedException
						 {
							List <WebElement> list = driver.findElements(By.tagName("H2"));
							System.out.println("Number of links: "+list.size());
							 for(int i = 0; i < list.size(); i++)
							 {
								 System.out.println(list.get(i).getText());
								 }

}}
