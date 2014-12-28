package RegisterdomainName;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;

import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Java class representation of a JSP page
 * <p/>
 * Date: Time: 10:57:37 PM
 *
 * @author Charles
 */
public class Page {
	protected WebDriver webdriver;
	protected By pageIdentifier;

	// Have to increase the wait time because logging in as system admin takes a
	// long time.
	public static final long WAIT_FOR_TIME = 120000;
//
//	protected Page(WebDriver webdriver, By pageIdentifier) {
//		this.webdriver = webdriver;
//		this.pageIdentifier = pageIdentifier;
//		
//
//		WebDriverWait wait = new WebDriverWait(webdriver, 60);// 1 minute 
//		wait.until(ExpectedConditions.visibilityOfElementLocated(pageIdentifier));
//		
//	}
	protected void waitFor(By locator) {
		WebDriverWait wait = new WebDriverWait(webdriver, 60);// 1 minute 
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	protected void ClickAndWaitFor(By clickable, By waitForLocator) {
		webdriver.findElement(clickable).click();
		
		WebDriverWait wait = new WebDriverWait(webdriver, 60);// 1 minute 
		wait.until(ExpectedConditions.visibilityOfElementLocated(waitForLocator));
	}

	public void pressBrowserBackButton(By locator) {
		webdriver.navigate().back();
		waitFor(locator);
	}

	/**
	 * Assert the page, using the specified identifier. Basically parse through
	 * the page, and try to find the identifier specified
	 *
	 */
	protected void assertPage() {
		assertLocator(pageIdentifier);
	}

	protected void assertLocator(By Locator) {

		String htmlSource = webdriver.getPageSource();
		if (htmlSource.contains("Internal Server Error")) {
			throw new RuntimeException("HTTP 500 Internal Server Error!!!");
		}
		if (htmlSource.contains("Error 404")) {
			throw new RuntimeException("HTTP 404 - Resource not found!!!");
		}
		boolean present;
	      try
	        {
	          webdriver.findElement(Locator);
	          present = true;
	        }catch (NoSuchElementException e)
	        {
	          present = false;
	         }
	      
	      assertTrue(present);
	}
	
	public boolean hasErrors(By locator) {
		return webdriver.findElement(locator) != null;
	}

	public List<String> getErrors() {

		return null;
	}

	public void waitForSystemError() {
		waitForAWhile(10000);
	}

	public void waitForValidationError() {
		waitForAWhile(10000);
	}

	protected void waitForAWhile(final int sleepTimeInMillis) {
		try {
			Thread.sleep(sleepTimeInMillis);
		} catch (InterruptedException e) {
		}
	}

}