package wrappers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import listeners.MyWebDriverListener;
import utils.Reporter;

public class SuperHelper extends Reporter implements CoreSuperHelper
{
	static ThreadLocal<WebDriver> driver= new ThreadLocal<>();
	public Properties configProp=new Properties();
	public Properties credentialsProp=new Properties();
	
	public WebDriver getWebDriver()
	{
		return driver.get();
	}
	
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "./src/main/java/drivers/chromedriver.exe");
		URL url =null;
		try
		{
			url = new URL("http://localhost:4444/wd/hub");
		} catch (MalformedURLException e)
		{
			e.printStackTrace();
		}

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		
		RemoteWebDriver remoteWebDriver = new RemoteWebDriver(url, dc);
		WebDriverListener driverListener = new MyWebDriverListener();
		
		driver.set(new EventFiringDecorator(driverListener).decorate(remoteWebDriver));
		
	}
	
	public void loadProperties()
	{
		try
		{
			configProp.load(new FileReader("./src/main/java/prop/config.properties"));
			credentialsProp.load(new FileReader("./src/main/java/prop/credentials.properties"));
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public WebElement locateElement(String locator, String locValue)
	{
		
		try
		{

			switch (locator)
			{
			case "id":
				return getWebDriver().findElement(By.id(locValue));
			case "name":
				return getWebDriver().findElement(By.name(locValue));
			case "class":
				return getWebDriver().findElement(By.className(locValue));
			case "link":
				return getWebDriver().findElement(By.linkText(locValue));
			case "xpath":
				return getWebDriver().findElement(By.xpath(locValue));
			default:
				break;
			}

		} catch (NoSuchElementException e)
		{
			log(Status.FAIL, "The element with locator " + locator + " not found.");
		} catch (WebDriverException e)
		{
			log(Status.FAIL, "Unknown exception occured while finding " + locator + " with the value " + locValue);
		}
		return null;
	}

	public WebElement locateElement(String locValue)
	{
		return getWebDriver().findElement(By.id(locValue));
	}

	public void enter(WebElement element, String data)
	{
		enter(element, data, false);
	}

	public void enter(WebElement element, String data, String elementOrFieldName, boolean takeScreenshotOrNo)
	{
		try
		{
			element.clear();
			element.sendKeys(data);
			log(Status.PASS, "The data: " + data + " entered successfully in the field " + elementOrFieldName,
					takeScreenshotOrNo);
		} catch (InvalidElementStateException e)
		{
			log(Status.FAIL, "The data: " + data + " could not be entered in the field " + elementOrFieldName, true);
		} catch (WebDriverException e)
		{
			e.printStackTrace();
			log(Status.FAIL, "Unknown exception occured while entering " + data + " in the field " + elementOrFieldName, true);
		}
	}
	
	
	public void enterTextAndClickTab(WebElement element, String data, String elementOrFieldName, boolean takeScreenshotOrNo)
	{
		try
		{
			element.clear();
			element.sendKeys(data);
			element.sendKeys(Keys.TAB);
			log(Status.PASS, "The data: " + data + " entered successfully in the field " + elementOrFieldName,
					takeScreenshotOrNo);
		} catch (InvalidElementStateException e)
		{
			log(Status.FAIL, "The data: " + data + " could not be entered in the field " + elementOrFieldName, true);
		} catch (WebDriverException e)
		{
			log(Status.FAIL, "Unknown exception occured while entering " + data + " in the field " + elementOrFieldName, true);
		}
	}

	public void enterTextAndClickEnter(WebElement element, String data, String elementOrFieldName, boolean takeScreenshotOrNo)
	{
		try
		{
			element.clear();
			element.sendKeys(data, Keys.ENTER);
			log(Status.PASS, "The data: " + data + " entered successfully in the field " + elementOrFieldName);
		} catch (InvalidElementStateException e)
		{
			log(Status.FAIL, "The data: " + data + " could not be entered in the field " + elementOrFieldName, true);
		} catch (WebDriverException e)
		{
			e.printStackTrace();
			log(Status.FAIL, "Unknown exception occured while entering " + data + " in the field " + elementOrFieldName, true);
		}
	}

	public void click(WebElement element, String elementOrFieldName)
	{
		click(element, elementOrFieldName, false);
	}

	public void click(WebElement element, String elementOrFieldName, boolean takeScreenshotOrNo)
	{
		try
		{
			element.click();
			log(Status.PASS, "The element " + element + " is clicked", takeScreenshotOrNo);
		} catch (InvalidElementStateException e)
		{
			log(Status.FAIL, "The element: " + element + " could not be clicked", true);
		} catch (WebDriverException e)
		{
			log(Status.FAIL, "Unknown exception occured while clicking in the field :", true);
		}
	}
	
	public void enter(WebElement element, String data, boolean takeScreenshotOrNo)
	{	
		String elementOrFieldName="";
		enter(element, data, elementOrFieldName, takeScreenshotOrNo);
	}
	
	
	public void enterTextAndClickTab(WebElement element, String data, boolean takeScreenshotOrNo)
	{
		String elementOrFieldName="";
		enterTextAndClickTab(element, data, elementOrFieldName, takeScreenshotOrNo);
	}

	public void enterTextAndClickEnter(WebElement element, String data, boolean takeScreenshotOrNo)
	{
		String elementOrFieldName="";
		enterTextAndClickEnter(element, data, elementOrFieldName, takeScreenshotOrNo);
	}

	public void click(WebElement element)
	{
		String elementOrFieldName="";
		click(element, elementOrFieldName, false);
	}

	public void click(WebElement element, boolean takeScreenshotOrNo)
	{
		String elementOrFieldName="";
		click(element, elementOrFieldName , takeScreenshotOrNo);
	}
	
	public String getText(WebElement element)
	{
		String text = "";
		try
		{
			text = element.getText();
		} catch (WebDriverException e)
		{
			log(Status.FAIL, "The element: " + element + " could not be found.");
		}
		return text;
	}

	public String getTitle()
	{
		String title = "";
		try
		{
			title = getWebDriver().getTitle();
		} catch (WebDriverException e)
		{
			log(Status.FAIL, "Unknown Exception Occured While fetching Title");
		}
		return title;
	}

	public String getAttribute(WebElement element, String attributeName)
	{
		String attributeValue = "";
		try
		{
			attributeValue = element.getAttribute(attributeName);
		} catch (WebDriverException e)
		{
			e.printStackTrace();
			log(Status.FAIL, "The element: " + element + " could not be found.");
		}
		return attributeValue;
	}

	public void selectDropDown(WebElement element, String visibleTextValue)
	{
		try
		{
			new Select(element).selectByVisibleText(visibleTextValue);
			log(Status.PASS, "The dropdown is selected with text " + visibleTextValue);
		} catch (WebDriverException e)
		{
			log(Status.FAIL, "The element: " + element + " could not be found.");
		}

	}

	public void deSelectDropDown(WebElement element, String visibleTextValue)
	{
		try
		{
			new Select(element).deselectByVisibleText(visibleTextValue);
			log(Status.PASS, "The dropdown is deselected with text " + visibleTextValue);
		} catch (WebDriverException e)
		{
			log(Status.FAIL, "The element: " + element + " could not be found.");
		}

	}

	public void selectDropDownByIndex(WebElement element, int index)
	{
		try
		{
			new Select(element).selectByIndex(index);
			log(Status.PASS, "The dropdown is selected with index " + index);
		} catch (WebDriverException e)
		{
			log(Status.FAIL, "The element: " + element + " could not be found.");
		}

	}

	public void deSelectDropDownByIndex(WebElement element, int index)
	{
		try
		{
			new Select(element).deselectByIndex(index);
			log(Status.PASS, "The dropdown is deselected with index " + index);
		} catch (WebDriverException e)
		{
			log(Status.FAIL, "The element: " + element + " could not be found.");
		}

	}
	
	public void selectDropDownByValue(WebElement element, String dropdownValue)
	{
		try
		{
			new Select(element).selectByValue(dropdownValue);
			log(Status.PASS, "The dropdown is selected with index " + dropdownValue);
		} catch (WebDriverException e)
		{
			log(Status.FAIL, "The element: " + element + " could not be found.");
		}

	}

	public void deSelectDropDownByValue(WebElement element, String dropdownValue)
	{
		try
		{
			new Select(element).deselectByValue(dropdownValue);
			log(Status.PASS, "The dropdown is deselected with index " + dropdownValue);
		} catch (WebDriverException e)
		{
			log(Status.FAIL, "The element: " + element + " could not be found.");
		}

	}

	public boolean verifyExactTitle(String title)
	{
		boolean bReturn = false;
		try
		{
			if (getTitle().equals(title))
			{
				log(Status.PASS, "The title of the page matches with the value :" + title);
				bReturn = true;
			} 
			else
			{
				log(Status.FAIL,
						"The title of the page:" + getWebDriver().getTitle() + " did not match with the value :" + title);
			}
		} 
		catch (WebDriverException e)
		{
			log(Status.FAIL, "Unknown exception occured while verifying the title");
		}
		return bReturn;
	}

	public void verifyExactText(WebElement element, String expectedText)
	{
		try
		{
			if (getText(element).equals(expectedText))
			{
				log(Status.PASS, "The text: " + getText(element) + " matches with the value :" + expectedText);
			} 
			else
			{
				log(Status.FAIL, "The text " + getText(element) + " doesn't matches the actual " + expectedText);
			}
		} catch (WebDriverException e)
		{
			log(Status.FAIL, "Unknown exception occured while verifying the Text");
		}

	}

	public void verifyPartialText(WebElement element, String expectedText)
	{
		try
		{
			if (getText(element).contains(expectedText))
			{
				log(Status.PASS, "The expected text contains the actual " + expectedText);
			} else
			{
				log(Status.FAIL, "The expected text doesn't contain the actual " + expectedText);
			}
		} catch (WebDriverException e)
		{
			log(Status.FAIL, "Unknown exception occured while verifying the Text");
		}
	}

	public void verifyExactAttributeValue(WebElement element, String attribute, String value)
	{
		try
		{
			if (getAttribute(element, attribute).equals(value))
			{
				log(Status.PASS, "The expected attribute :" + attribute + " value matches the actual " + value);
			} 
			else
			{
				log(Status.FAIL,
						"The expected attribute :" + attribute + " value does not matches the actual " + value);
			}
		} catch (WebDriverException e)
		{
			log(Status.FAIL, "Unknown exception occured while verifying the Attribute Text");
		}

	}

	public void verifyPartialAttributeValue(WebElement element, String attribute, String value)
	{
		try
		{
			if (getAttribute(element, attribute).contains(value))
			{
				log(Status.PASS, "The expected attribute :" + attribute + " value contains the actual " + value);
			} else
			{
				log(Status.FAIL,
						"The expected attribute :" + attribute + " value does not contains the actual " + value);
			}
		} catch (WebDriverException e)
		{
			log(Status.FAIL, "Unknown exception occured while verifying the Attribute Text");
		}
	}

	public void verifyElementIsSelected(WebElement element)
	{
		try
		{
			if (element.isSelected())
			{
				log(Status.PASS, "The element " + element + " is selected");
			} else
			{
				log(Status.FAIL, "The element " + element + " is not selected");
			}
		} catch (WebDriverException e)
		{
			log(Status.FAIL, "WebDriverException : " + e.getMessage());
		}
	}

	public void verifyElementIsDisplayed(WebElement element)
	{
		try
		{
			if (element.isDisplayed())
			{
				log(Status.PASS, "The element " + element + " is visible");
			} else
			{
				log(Status.FAIL, "The element " + element + " is not visible");
			}
		} 
		catch (WebDriverException e)
		{
			log(Status.FAIL, "WebDriverException : " + e.getMessage());
		}
	}

	public void switchToWindow(int index)
	{
		try
		{
			Set<String> allWindowHandles = getWebDriver().getWindowHandles();
			List<String> allHandles = new ArrayList<>();
			allHandles.addAll(allWindowHandles);
			getWebDriver().switchTo().window(allHandles.get(index));
		} 
		catch (NoSuchWindowException e)
		{
			log(Status.FAIL, "The getWebDriver() could not move to the given window by index " + index);
		} 
		catch (WebDriverException e)
		{
			log(Status.FAIL, "WebDriverException : " + e.getMessage());
		}
	}

	public void switchToFrame(WebElement element)
	{
		try
		{
			getWebDriver().switchTo().frame(element);
			log(Status.PASS, "Switched In to the Frame " + element);
		} catch (NoSuchFrameException e)
		{
			log(Status.FAIL, "WebDriverException : " + e.getMessage());
		} catch (WebDriverException e)
		{
			log(Status.FAIL, "WebDriverException : " + e.getMessage());
		}
	}

	public void acceptAlert()
	{
		String text = "";
		try
		{
			Alert alert = getWebDriver().switchTo().alert();
			text = alert.getText();
			alert.accept();
			log(Status.PASS, "The alert " + text + " is accepted.");
		} catch (NoAlertPresentException e)
		{
			log(Status.FAIL, "There is no alert present.");
		} catch (WebDriverException e)
		{
			log(Status.FAIL, "WebDriverException : " + e.getMessage());
		}
	}

	public void dismissAlert()
	{
		String text = "";
		try
		{
			Alert alert = getWebDriver().switchTo().alert();
			text = alert.getText();
			alert.dismiss();
			log(Status.PASS, "The alert " + text + " is dismissed.");
		} catch (NoAlertPresentException e)
		{
			log(Status.FAIL, "There is no alert present.");
		} catch (WebDriverException e)
		{
			log(Status.FAIL, "WebDriverException : " + e.getMessage());
		}

	}

	public String getAlertText()
	{
		String text = "";
		try
		{
			Alert alert = getWebDriver().switchTo().alert();
			text = alert.getText();
		} 
		catch (NoAlertPresentException e)
		{
			log(Status.FAIL, "There is no alert present.");
		} 
		catch (WebDriverException e)
		{
			log(Status.FAIL, "WebDriverException : " + e.getMessage());
		}
		return text;
	}

	public void closeActiveBrowserWindow()
	{
		try
		{
			getWebDriver().close();
			log(Status.PASS, "The browser current window/tab is closed");
		} catch (Exception e)
		{
			log(Status.FAIL, "The browser could not be closed");
		}
	}

	public void closeAllBrowsers()
	{
		try
		{
			getWebDriver().quit();
			log(Status.PASS, "The opened browsers are closed");
		} catch (Exception e)
		{
			log(Status.FAIL, "Unexpected error occured in Browser");
		}
	}


	@Override
	public boolean verifyPartialTitle(String title)
	{
		boolean bReturn = false;
		try
		{
			if (getTitle().contains(title))
			{
				log(Status.PASS, "The title of the page matches with the value :" + title);
				bReturn = true;
			} else
			{
				log(Status.FAIL,
						"The title of the page:" + getWebDriver().getTitle() + " did not match with the value :" + title);
			}
		} catch (WebDriverException e)
		{
			log(Status.FAIL, "Unknown exception occured while verifying the title");
		}
		return bReturn;
	}

	public void waitForElementToBeVisible(WebElement element, int waitTimeoutInMillis)
	{
		WebDriverWait wait=new WebDriverWait(getWebDriver(), Duration.ofMillis(waitTimeoutInMillis));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToBeClickable(WebElement element, int waitTimeoutInMillis)
	{
		WebDriverWait wait=new WebDriverWait(getWebDriver(), Duration.ofMillis(waitTimeoutInMillis));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForAlert(WebElement element, int waitTimeoutInMillis)
	{
		WebDriverWait wait=new WebDriverWait(getWebDriver(), Duration.ofMillis(waitTimeoutInMillis));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void waitForFrameToBeAvailableAndSwitch(WebElement element, int waitTimeoutInMillis)
	{
		WebDriverWait wait=new WebDriverWait(getWebDriver(), Duration.ofMillis(waitTimeoutInMillis));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}
	
	public void waitForNumOfWindowsToBe(int numOfWindows, int waitTimeoutInMillis)
	{
		WebDriverWait wait=new WebDriverWait(getWebDriver(), Duration.ofMillis(waitTimeoutInMillis));
		wait.until(ExpectedConditions.numberOfWindowsToBe(numOfWindows));
	}
	
	public void waitForElementToBeVisible(WebElement element, Duration duration, int waitTimeout)
	{
		WebDriverWait wait=new WebDriverWait(getWebDriver(), Duration.ofMillis(waitTimeout));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToBeClickable(WebElement element, Duration duration, int waitTimeout)
	{
		WebDriverWait wait=new WebDriverWait(getWebDriver(), Duration.ofMillis(waitTimeout));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForAlert(WebElement element, Duration duration, int waitTimeout)
	{
		WebDriverWait wait=new WebDriverWait(getWebDriver(), Duration.ofMillis(waitTimeout));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void waitForFrameToBeAvailableAndSwitch(WebElement element, Duration duration, int waitTimeout)
	{
		WebDriverWait wait=new WebDriverWait(getWebDriver(), Duration.ofMillis(waitTimeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}
	
	public void waitForNumOfWindowsToBe(int numOfWindows, Duration duration, int waitTimeout)
	{
		WebDriverWait wait=new WebDriverWait(getWebDriver(), Duration.ofMillis(waitTimeout));
		wait.until(ExpectedConditions.numberOfWindowsToBe(numOfWindows));
	}
	
	


	public String getCurrentDateAndTimeAsString()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date date = new Date();
		String currentDataAndTime = formatter.format(date);
		return currentDataAndTime;
	}

	public String getRandomNumberAsString()
	{
		Random random = new Random();
		int randomNum1 = random.nextInt(10000);
		int randomNum2 = random.nextInt(10000);
		int randomNum3 = random.nextInt(10000);
		int sum = randomNum1 + randomNum2 + randomNum3;
		String sumAsString = String.valueOf(sum);
		return sumAsString;
	}

	@Override
	public String takeScreenshot()
	{
		String filePath = "./test-output/screenshots/";
		return takeScreenshot(filePath);
	}

	public String takeScreenshot(String fileFolderPathWithoutFileName)
	{
		String filePath = fileFolderPathWithoutFileName;
		String fileFormat = ".jpg";
		String fileName = getCurrentDateAndTimeAsString().concat(getRandomNumberAsString());

		return takeScreenshot(filePath, fileName, fileFormat);
	}

	public String takeScreenshot(String filePath, String fileName, String fileFormat)
	{
		String fullFilenameWithPath = filePath.concat(fileName).concat(fileFormat);

		File source = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);
		File destination = new File(fullFilenameWithPath);
		try
		{
			FileUtils.copyFile(source, destination);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return fullFilenameWithPath;
	}

	//JavascriptExecutor
	public void executeJavascript(String script)
	{
		JavascriptExecutor js=(JavascriptExecutor)getWebDriver();
		js.executeScript(script);
	}
	
	public void executeAsyncJavascript(String script)
	{
		JavascriptExecutor js=(JavascriptExecutor)getWebDriver();
		js.executeAsyncScript(script);
	}
	
	public void executeJavascript(String script, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)getWebDriver();
		js.executeScript(script, element);
	}
	
	public void executeAsyncJavascript(String script, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)getWebDriver();
		js.executeAsyncScript(script, element);
	}
	
	public void clickUsingJavascript(WebElement element)
	{
		clickUsingJavascript(element, false);
	}
	
	public void clickUsingJavascript(WebElement element, String fieldOrElementName)
	{
		 clickUsingJavascript(element, fieldOrElementName, false);
	}
	
	
	public void clickUsingJavascript(WebElement element, boolean takeScreenshotOrNo)
	{
		 String fieldOrElementName="";
		 clickUsingJavascript(element, fieldOrElementName, takeScreenshotOrNo);
	}

	public void clickUsingJavascript(WebElement element, String fieldOrElementName, boolean takeScreenshotOrNo)
	{
		try
		{
			executeJavascript("arguments[0].click();", element);
			log(Status.PASS, "The element " + fieldOrElementName + " is clicked", takeScreenshotOrNo);
		} catch (InvalidElementStateException e)
		{
			log(Status.FAIL, "The element: " + fieldOrElementName + " could not be clicked", true);
		} catch (WebDriverException e)
		{
			log(Status.FAIL, "Unknown exception occured while clicking in the field :", true);
		}
	}
	
	public void enterUsingJavascript(WebElement element, String data)
	{
		String fieldOrElementName="";
		enterUsingJavascript(element, data, fieldOrElementName, false);
	}
	
	public void enterUsingJavascript(WebElement element, String data, String fieldOrElementName)
	{
		enterUsingJavascript(element, data, fieldOrElementName, false);
	}

	public void enterUsingJavascript(WebElement element, String data, boolean takeScreenshotOrNo)
	{
		String fieldOrElementName="";
		enterUsingJavascript(element, data, fieldOrElementName, takeScreenshotOrNo);
	}
	
	public void enterUsingJavascript(WebElement element, String data, String fieldOrElementName, boolean takeScreenshotOrNo)
	{
		try
		{
			executeJavascript("arguments[0].value='"+data+"'", element);
			log(Status.PASS, "The data: " + data + " entered successfully in the field " + fieldOrElementName,
					takeScreenshotOrNo);
		} catch (InvalidElementStateException e)
		{
			log(Status.FAIL, "The data: " + data + " could not be entered in the field " + fieldOrElementName, true);
		} catch (WebDriverException e)
		{
			e.printStackTrace();
			log(Status.FAIL, "Unknown exception occured while entering " + data + " in the field " + fieldOrElementName, true);
		}
	}
	
	public void scrollElementIntoView(WebElement element)
	{
		executeJavascript("arguments[0].scrollIntoView();", element);
	}
	
	//Actions
	public void clickUsingActions(WebElement element)
	{
		clickUsingActions(element, false);
	}

	public void clickUsingActions(WebElement element, boolean takeScreenshotOrNo)
	{
		try
		{
			Actions actions=new Actions(getWebDriver());
			actions.moveToElement(element).click().build().perform();
			log(Status.PASS, "The element " + element + " is clicked", takeScreenshotOrNo);
		} catch (InvalidElementStateException e)
		{
			log(Status.FAIL, "The element: " + element + " could not be clicked", true);
		} catch (WebDriverException e)
		{
			log(Status.FAIL, "Unknown exception occured while clicking in the field :", true);
		}
	}
	
	public void enterUsingActions(WebElement element, String data)
	{
		enterUsingActions(element, data, false);
	}

	public void enterUsingActions(WebElement element, String data, boolean takeScreenshotOrNo)
	{
		try
		{
			Actions actions=new Actions(getWebDriver());
			actions.moveToElement(element).sendKeys(data).build().perform();
			log(Status.PASS, "The data: " + data + " entered successfully in the field :" + element,
					takeScreenshotOrNo);
		} catch (InvalidElementStateException e)
		{
			log(Status.FAIL, "The data: " + data + " could not be entered in the field :" + element, true);
		} catch (WebDriverException e)
		{
			e.printStackTrace();
			log(Status.FAIL, "Unknown exception occured while entering " + data + " in the field :" + element, true);
		}
	}
	

}
