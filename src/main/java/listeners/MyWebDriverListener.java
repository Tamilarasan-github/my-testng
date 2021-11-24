package listeners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.events.WebDriverListener;

public class MyWebDriverListener extends MyTestNGListenersImpl implements WebDriverListener
{
	private static Logger log = LogManager.getLogger(MyWebDriverListener.class.getName());
	// Global

	public void beforeAnyCall(Object target, Method method, Object[] args)
	{
		log.debug("Webdriver Listener beforeAnyCall");
	}

	public void afterAnyCall(Object target, Method method, Object[] args, Object result)
	{
		log.debug("Webdriver Listener afterAnyCall");
	}

	public void onError(Object target, Method method, Object[] args, InvocationTargetException e)
	{
		log.debug("Webdriver Listener  ");
	}

	// WebDriver

	public void beforeAnyWebDriverCall(WebDriver driver, Method method, Object[] args)
	{
		log.debug("Webdriver Listener beforeAnyWebDriverCall:" + driver);
	}

	public void afterAnyWebDriverCall(WebDriver driver, Method method, Object[] args, Object result)
	{
		log.debug("Webdriver Listener afterAnyWebDriverCall:" + driver);
	}

	public void beforeGet(WebDriver driver, String url)
	{
		log.debug("Webdriver Listener beforeGet:" + driver);
	}

	public void afterGet(WebDriver driver, String url)
	{
		log.debug("Webdriver Listener afterGet:" + driver);
	}

	public void beforeGetCurrentUrl(WebDriver driver)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterGetCurrentUrl(String result, WebDriver driver)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeGetTitle(WebDriver driver)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterGetTitle(WebDriver driver, String result)
	{
		log.debug("Webdriver Listener afterGetTitle(WebDriver driver, String result)");
	}

	public void beforeFindElement(WebDriver driver, By locator)
	{
		log.debug("Webdriver Listener beforeFindElement(WebDriver driver, By locator):" + driver + " locator:" + locator);
	}

	public void afterFindElement(WebDriver driver, By locator, WebElement result)
	{
		log.debug("Webdriver Listener afterFindElement(WebDriver driver, By locator, WebElement result):" + driver + " locator:" + locator + " result:" + result);
	}

	public void beforeFindElements(WebDriver driver, By locator)
	{
		log.debug("Webdriver Listener beforeFindElements(WebDriver driver, By locator):" + driver + " locator:" + locator);
	}

	public void afterFindElements(WebDriver driver, By locator, List<WebElement> result)
	{
		log.debug("Webdriver Listener afterFindElements(WebDriver driver, By locator, List<WebElement> result):" + driver + " locator:" + locator + " result:" + result);
	}

	public void beforeGetPageSource(WebDriver driver)
	{
		log.debug("Webdriver Listener beforeGetPageSource(WebDriver driver):" + driver);
	}

	public void afterGetPageSource(WebDriver driver, String result)
	{
		log.debug("Webdriver Listener afterGetPageSource(WebDriver driver, String result):" + driver);
	}

	public void beforeClose(WebDriver driver)
	{
		log.debug("Webdriver Listener beforeClose(WebDriver driver): "+driver);
	}

	public void afterClose(WebDriver driver)
	{
		log.debug("Webdriver Listener afterClose(WebDriver driver): "+driver);
	}

	public void beforeQuit(WebDriver driver)
	{
		log.debug("Webdriver Listener beforeQuit(WebDriver driver): "+driver);
	}

	public void afterQuit(WebDriver driver)
	{
		log.debug("Webdriver Listener afterQuit(WebDriver driver): "+driver);
	}

	public void beforeGetWindowHandles(WebDriver driver)
	{
		log.debug("Webdriver Listener beforeGetWindowHandles(WebDriver driver):"+driver+" | Windows Count:"+driver.getWindowHandles().size());
	}

	public void afterGetWindowHandles(WebDriver driver, Set<String> result)
	{
		log.debug("Webdriver Listener afterGetWindowHandles(WebDriver driver, Set<String> result):"+driver+" | Windows Count:"+driver.getWindowHandles().size());
	}

	public void beforeGetWindowHandle(WebDriver driver)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterGetWindowHandle(WebDriver driver, String result)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeExecuteScript(WebDriver driver, String script, Object[] args)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterExecuteScript(WebDriver driver, String script, Object[] args, Object result)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeExecuteAsyncScript(WebDriver driver, String script, Object[] args)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterExecuteAsyncScript(WebDriver driver, String script, Object[] args, Object result)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforePerform(WebDriver driver, Collection<Sequence> actions)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterPerform(WebDriver driver, Collection<Sequence> actions)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeResetInputState(WebDriver driver)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterResetInputState(WebDriver driver)
	{
		log.debug("Webdriver Listener  ");
	}

	// WebElement

	public void beforeAnyWebElementCall(WebElement element, Method method, Object[] args)
	{

	}

	public void afterAnyWebElementCall(WebElement element, Method method, Object[] args, Object result)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeClick(WebElement element)
	{
		log.debug("Webdriver Listener beforeClick: Element is yet to be clicked " + element.getAccessibleName());
	}

	public void afterClick(WebElement element)
	{
		log.debug("Webdriver Listener afterClick: Element clicked " + element.getAccessibleName());
	}

	public void beforeSubmit(WebElement element)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterSubmit(WebElement element)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeSendKeys(WebElement element, CharSequence... keysToSend)
	{
		log.debug(
				"Webdriver Listener beforeSendKeys(WebElement element, CharSequence... keysToSend): Text yet to be entered is "
						+ keysToSend.toString());
	}

	public void afterSendKeys(WebElement element, CharSequence... keysToSend)
	{
		log.debug("Webdriver Listener afterSendKeys(WebElement element, CharSequence... keysToSend): Text entered is "
				+ keysToSend.toString());
	}

	public void beforeClear(WebElement element)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterClear(WebElement element)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeGetTagName(WebElement element)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterGetTagName(WebElement element, String result)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeGetAttribute(WebElement element, String name)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterGetAttribute(WebElement element, String name, String result)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeIsSelected(WebElement element)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterIsSelected(WebElement element, boolean result)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeIsEnabled(WebElement element)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterIsEnabled(WebElement element, boolean result)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeGetText(WebElement element)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterGetText(WebElement element, String result)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeFindElement(WebElement element, By locator)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterFindElement(WebElement element, By locator, WebElement result)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeFindElements(WebElement element, By locator)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterFindElements(WebElement element, By locator, List<WebElement> result)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeIsDisplayed(WebElement element)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterIsDisplayed(WebElement element, boolean result)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeGetLocation(WebElement element)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterGetLocation(WebElement element, Point result)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeGetSize(WebElement element)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterGetSize(WebElement element, Dimension result)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeGetCssValue(WebElement element, String propertyName)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterGetCssValue(WebElement element, String propertyName, String result)
	{
		log.debug("Webdriver Listener  ");
	}

	// Navigation

	public void beforeAnyNavigationCall(WebDriver.Navigation navigation, Method method, Object[] args)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterAnyNavigationCall(WebDriver.Navigation navigation, Method method, Object[] args, Object result)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeTo(WebDriver.Navigation navigation, String url)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterTo(WebDriver.Navigation navigation, String url)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeTo(WebDriver.Navigation navigation, URL url)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterTo(WebDriver.Navigation navigation, URL url)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeBack(WebDriver.Navigation navigation)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterBack(WebDriver.Navigation navigation)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeForward(WebDriver.Navigation navigation)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterForward(WebDriver.Navigation navigation)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeRefresh(WebDriver.Navigation navigation)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterRefresh(WebDriver.Navigation navigation)
	{
		log.debug("Webdriver Listener  ");
	}

	// Alert

	public void beforeAnyAlertCall(Alert alert, Method method, Object[] args)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterAnyAlertCall(Alert alert, Method method, Object[] args, Object result)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeAccept(Alert alert)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterAccept(Alert alert)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeDismiss(Alert alert)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterDismiss(Alert alert)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeGetText(Alert alert)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterGetText(Alert alert, String result)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeSendKeys(Alert alert, String text)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterSendKeys(Alert alert, String text)
	{
		log.debug("Webdriver Listener  ");
	}

	// Options

	public void beforeAnyOptionsCall(WebDriver.Options options, Method method, Object[] args)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterAnyOptionsCall(WebDriver.Options options, Method method, Object[] args, Object result)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeAddCookie(WebDriver.Options options, Cookie cookie)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterAddCookie(WebDriver.Options options, Cookie cookie)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeDeleteCookieNamed(WebDriver.Options options, String name)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterDeleteCookieNamed(WebDriver.Options options, String name)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeDeleteCookie(WebDriver.Options options, Cookie cookie)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterDeleteCookie(WebDriver.Options options, Cookie cookie)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeDeleteAllCookies(WebDriver.Options options)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterDeleteAllCookies(WebDriver.Options options)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeGetCookies(WebDriver.Options options)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterGetCookies(WebDriver.Options options, Set<Cookie> result)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeGetCookieNamed(WebDriver.Options options, String name)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterGetCookieNamed(WebDriver.Options options, String name, Cookie result)
	{
		log.debug("Webdriver Listener  ");
	}

	// Timeouts

	public void beforeAnyTimeoutsCall(WebDriver.Timeouts timeouts, Method method, Object[] args)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterAnyTimeoutsCall(WebDriver.Timeouts timeouts, Method method, Object[] args, Object result)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeImplicitlyWait(WebDriver.Timeouts timeouts, Duration duration)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterImplicitlyWait(WebDriver.Timeouts timeouts, Duration duration)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeSetScriptTimeout(WebDriver.Timeouts timeouts, Duration duration)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterSetScriptTimeout(WebDriver.Timeouts timeouts, Duration duration)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforePageLoadTimeout(WebDriver.Timeouts timeouts, Duration duration)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterPageLoadTimeout(WebDriver.Timeouts timeouts, Duration duration)
	{
		log.debug("Webdriver Listener  ");
	}

	// Window

	public void beforeAnyWindowCall(WebDriver.Window window, Method method, Object[] args)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterAnyWindowCall(WebDriver.Window window, Method method, Object[] args, Object result)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeGetSize(WebDriver.Window window)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterGetSize(WebDriver.Window window, Dimension result)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeSetSize(WebDriver.Window window, Dimension size)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterSetSize(WebDriver.Window window, Dimension size)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeGetPosition(WebDriver.Window window)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterGetPosition(WebDriver.Window window, Point result)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeSetPosition(WebDriver.Window window, Point position)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterSetPosition(WebDriver.Window window, Point position)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeMaximize(WebDriver.Window window)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterMaximize(WebDriver.Window window)
	{
		log.debug("Webdriver Listener  ");
	}

	public void beforeFullscreen(WebDriver.Window window)
	{
		log.debug("Webdriver Listener  ");
	}

	public void afterFullscreen(WebDriver.Window window)
	{
		log.debug("Webdriver Listener  ");
	}
}
