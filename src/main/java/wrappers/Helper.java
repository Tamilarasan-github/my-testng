package wrappers;

import java.time.Duration;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public interface Helper {



	/**
	 * This method will locate the element using any given locator
	 * @param locatorType  - The locator by which the element to be found
	 * @param locValue - The locator value by which the element to be found
	 * @author Tamilarasan S
	 * @return WebElement - the first matching element
	 * @throws NoSuchElementException
	 */
	public WebElement locateElement(String locatorType, String locValue) ;	


	/**
	 * This method will enter the value in the given text field 
	 * @param ele   - The Webelement (text field) in which the data to be entered
	 * @param data  - The data to be sent to the webelement
	 * @author Tamilarasan S
	 * @throws ElementNotVisibleException		 * 
	 */
	public void enter(WebElement element, String data, boolean takeScreenshot) ;

	/**
	 * This method will click the element and take snap
	 * @param ele   - The Webelement (button/link/element) to be clicked
	 * @author Tamilarasan S
	 */
	public void click(WebElement ele);

	/**
	 * This method will get the text of the element
	 * @param ele   - The Webelement (button/link/element) in which text to be retrieved
	 * @author Tamilarasan S
	 */
	public String getText(WebElement ele);

	/**
	 * This method will select the drop down visible text
	 * @param ele   - The Webelement (dropdown) to be selected
	 * @param value The value to be selected (visibletext) from the dropdown 
	 * @author Tamilarasan S
	 */
	public void selectDropDown(WebElement element, String value) ;

	/**
	 * This method will select the drop down using value
	 * @param ele   - The Webelement (dropdown) to be selected
	 * @param value The value attribute to be selected from the dropdown 
	 * @author Tamilarasan S
	 */
	public void selectDropDownByValue(WebElement element, String value) ;
	
	/**
	 * This method will select the drop down using index
	 * @param ele   - The Webelement (dropdown) to be selected
	 * @param index The index to be selected from the dropdown 
	 * @author Tamilarasan S
	 */
	public void selectDropDownByIndex(WebElement element, int index) ;

	/**
	 * This method will verify browser actual title with expected
	 * @param title - The expected title of the browser
	 * @author Tamilarasan S
	 */
	public boolean verifyExactTitle(String expectedTitle);
	
	/**
	 * This method will verify browser actual title with expected text using contains
	 * @param title - The expected title of the browser
	 * @author Tamilarasan S
	 */
	public boolean verifyPartialTitle(String expectedTitle);


	/**
	 * This method will verify exact given text with actual text on the given element
	 * @param ele   - The Webelement in which the text to be need to be verified
	 * @param expectedText  - The expected text to be verified
	 * @author Tamilarasan S
	 */
	public void verifyExactText(WebElement element, String expectedText);

	/**
	 * This method will verify given text contains actual text on the given element
	 * @param ele   - The Webelement in which the text to be need to be verified
	 * @param expectedText  - The expected text to be verified
	 * @author Tamilarasan S
	 */
	public void verifyPartialText(WebElement element, String expectedText);

	/**
	 * This method will verify exact given attribute's value with actual value on the given element
	 * @param ele   - The Webelement in which the attribute value to be need to be verified
	 * @param attribute  - The attribute to be checked (like value, href etc)
	 * @param value  - The value of the attribute
	 * @author Tamilarasan S
	 */
	public void verifyExactAttributeValue(WebElement element, String attribute, String value);

	/**
	 * This method will verify partial given attribute's value with actual value on the given element
	 * @param ele   - The Webelement in which the attribute value to be need to be verified
	 * @param attribute  - The attribute to be checked (like value, href etc)
	 * @param value  - The value of the attribute
	 * @author Tamilarasan S
	 */
	public void verifyPartialAttributeValue(WebElement element, String attribute, String value);

	/**
	 * This method will verify if the element (Radio button, Checkbox)  is selected
	 * @param ele   - The Webelement (Radio button, Checkbox) to be verified
	 * @author Tamilarasan S
	 */
	public void verifyElementIsSelected(WebElement ele);

	/**
	 * This method will verify if the element is visible in the DOM
	 * @param ele   - The Webelement to be checked
	 * @author Tamilarasan S
	 */
	public void verifyElementIsDisplayed(WebElement ele);

	/**
	 * This method will switch to the Window of interest
	 * @param index The window index to be switched to. 0 -> first window 
	 * @author Tamilarasan S
	 */
	public void switchToWindow(int index);

	/**
	 * This method will switch to the specific frame
	 * @param ele   - The Webelement (frame) to be switched
	 * @author Tamilarasan S
	 */
	public void switchToFrame(WebElement ele);

	/**
	 * This method will accept the alert opened
	 * @author Tamilarasan S
	 */
	public void acceptAlert();

	/**
	 * This method will dismiss the alert opened
	 * @author Tamilarasan S
	 */
	public void dismissAlert();

	/**
	 * This method will return the text of the alert
	 * @author Tamilarasan S
	 */
	public String getAlertText();

	/**
	 * This method will close the active browser
	 * @author Tamilarasan S
	 */
	public void closeActiveBrowserWindow();		

	/**
	 * This method will close all the browsers
	 * @author Tamilarasan S
	 */
	public void closeAllBrowsers();
	
	/**
	 * This method will take screenshot and returns filename with FilePath
	 * @author Tamilarasan S
	 */
	public String takeScreenshot();
	
	/**
	 * This method will wait for the web element to be visible
	 * @author Tamilarasan S
	 */
	public void waitForElementToBeVisible(WebElement element, int waitTimeoutInMillis);
	
	/**
	 * This method will wait for the web element to be clickable
	 * @author Tamilarasan S
	 */
	public void waitForElementToBeClickable(WebElement element, int waitTimeoutInMillis);
	
	/**
	 * This method will wait for the alert to be present
	 * @author Tamilarasan S
	 */
	public void waitForAlert(WebElement element, int waitTimeoutInMillis);
	
	/**
	 * This method will wait for the frame
	 * @author Tamilarasan S
	 */
	public void waitForFrameToBeAvailableAndSwitch(WebElement element, int waitTimeoutInMillis);
	
	/**
	 * This method will wait for the number of windows count to be
	 * @author Tamilarasan S
	 */
	public void waitForNumOfWindowsToBe(int numOfWindows, int waitTimeoutInMillis);
	
	/**
	 * This method will wait for the web element to be
	 * @author Tamilarasan S
	 */
    public void waitForElementToBeVisible(WebElement element, Duration duration, int waitTimeout);
	
    /**
	 * This method will wait for the web element to be clickable
	 * @author Tamilarasan S
	 */
	public void waitForElementToBeClickable(WebElement element, Duration duration, int waitTimeout);
	
	/**
	 * This method will wait for the alert to be present
	 * @author Tamilarasan S
	 */
	public void waitForAlert(WebElement element, Duration duration, int waitTimeout);
	
	/**
	 * This method will wait for the frame to be available
	 * @author Tamilarasan S
	 */
	public void waitForFrameToBeAvailableAndSwitch(WebElement element, Duration duration, int waitTimeout);
	
	/**
	 * This method will wait for the number of windows count to be
	 * @author Tamilarasan S
	 */
	public void waitForNumOfWindowsToBe(int numOfWindows, Duration duration, int waitTimeout);
	
	/**
	 * This method will return Current Date and Time as String format
	 * @author Tamilarasan S
	 */
	public String getCurrentDateAndTimeAsString();
	
	/**
	 * This method will random number as String
	 * @author Tamilarasan S
	 */
	public String getRandomNumberAsString();
	
	/**
	 * This method will take script and execute them using JavascriptExecutor 
	 * @author Tamilarasan S
	 */
	public void  executeJavascript(String script);
	
	/**
	 * This method will take script and execute them using JavascriptExecutor Async
	 * @author Tamilarasan S
	 */
	public void  executeAsyncJavascript(String script);
	
	/**
	 * This method will get two arguments script and web element and execute them using JavascriptExecutor 
	 * @param ele   - The Webelement (button/link/element)
	 * @author Tamilarasan S
	 */
	public void  executeJavascript(String script, WebElement element);
	
	/**
	 * This method will get two arguments script and web element and execute them using JavascriptExecutor Async
	 * @param ele   - The Webelement (button/link/element) 
	 * @author Tamilarasan S
	 */
	public void  executeAsyncJavascript(String script, WebElement element);
	
	/**
	 * This method will click the element using JavascriptExecutor
	 * @param ele   - The Webelement (button/link/element) to be clicked
	 * @author Tamilarasan S
	 */
	public void clickUsingJavascript(WebElement element);
	
	/**
	 * This method will click the element using JavascriptExecutor and take snap
	 * @param ele   - The Webelement (button/link/element) to be clicked
	 * @author Tamilarasan S
	 */
	public void clickUsingJavascript(WebElement element, boolean takeScreenshotOrNo);
	
	/**
	 * This method will enter the value in the given text field using JavascriptExecutor
	 * @param ele   - The Webelement (text field) in which the data to be entered
	 * @param data  - The data to be sent to the webelement
	 * @author Tamilarasan S		 
	 */
	public void enterUsingJavascript(WebElement element, String data);
	
	/**
	 * This method will enter the value in the given text field using JavascriptExecutor
	 * @param ele   - The Webelement (text field) in which the data to be entered
	 * @param data  - The data to be sent to the webelement
	 * @author Tamilarasan S
	 */
	public void enterUsingJavascript(WebElement element, String data, boolean takeScreenshotOrNo) ;

	/**
	 * This method will scroll till the web element is visible using JavascriptExecutor
	 * @param ele   - The Webelement (text field) in which the data to be entered
	 * @param data  - The data to be sent to the webelement
	 * @author Tamilarasan S
	 */
	public void scrollElementIntoView(WebElement element) ;
}
