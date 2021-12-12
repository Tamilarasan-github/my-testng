package testscripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import listeners.MyWebDriverListener;
import wrappers.Helper;

public class T001_Google extends Helper
{
	private static Logger log = LogManager.getLogger(T001_Google.class.getName());

	@BeforeClass
	public void setValues()
	{
		description = "Open Google and Search";
		testcaseName = "T001_Google";
	}

	@BeforeGroups(value ={ "Smoke" })
	public void beforeGroup()
	{
		System.out.println("BeforeGroup is executed");
	}

	@Test(invocationCount = 4, groups =
	{ "Smoke" }, threadPoolSize = 5)
	public void openGoogle()
	{
		// WebDriverManager.chromedriver().setup();
		log.debug("Browser is about to open");

		openBrowser();
		
		log.debug("Browser is opened");
		getWebDriver().get("https:\\www.google.com");
		log.debug("Browser is opened and URL is loaded");

		WebElement searchBar = getWebDriver().findElement(By.name("q"));
		enterTextAndClickEnter(searchBar, "Hello World This is my time now", true);
		log.debug("Hello World is entered into search bar");
		getWebDriver().quit();

		System.out.println("First Test Executed");
	}

	@Test(invocationCount = 1, groups =
	{ "Smoke" })
	public void openGoogleTwo()
	{
		System.out.println("2nd Test Executed");
	}

	@Test(invocationCount = 1, groups =
	{ "Smoke" })
	public void openGoogleThree()
	{
		System.out.println("3rd Test Executed");
	}
}
