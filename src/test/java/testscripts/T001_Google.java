package testscripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.MyWebDriverListener;
import wrappers.CoreSuperHelper;

public class T001_Google extends CoreSuperHelper
{
	private static Logger log=LogManager.getLogger(T001_Google.class.getName());
	
	@BeforeClass
	public void setValues()
	{
		description="Open Google and Search";
		testcaseName="T001_Google";
	}
	
	@Test(invocationCount = 1)
	public void openGoogle() 
	{
		WebDriverManager.chromedriver().setup();
		log.debug("Browser is about to open");
		RemoteWebDriver remoteWebDriver = new ChromeDriver();
		WebDriverListener  driverListener=new MyWebDriverListener();
		WebDriver driver = new EventFiringDecorator(driverListener).decorate(remoteWebDriver);
		log.debug("Browser is opened");
		driver.get("https:\\www.google.com");
		log.debug("Browser is opened and URL is loaded");
		
		WebElement searchBar=driver.findElement(By.name("q"));
		enterTextAndClickEnter(searchBar, "Hello World This is my time now", true);
		log.debug("Hello World is entered into search bar");
		driver.getWindowHandles();
		driver.quit();
	}
}
