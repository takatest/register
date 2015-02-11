package RegisterdomainName;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import static org.junit.Assert.*;

public class SearchDomainPage extends Page {

	public void searchDomain(WebDriver driver, String domain) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector("div.element-group > input[name=\"query\"]")));

		driver.findElement(
				By.cssSelector("div.element-group > input[name=\"query\"]"))
				.clear();
		driver.findElement(
				By.cssSelector("div.element-group > input[name=\"query\"]"))
				.sendKeys(domain);

		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click(); // search
																				// button
		By btn = By.xpath("//div[@id='main']/div/div/div/div[2]/div/div/div/button");

		waitForAWhile(5000);

		// assertEquals("is available",
		// driver.findElement(By.cssSelector("h2.ng-binding.positive")).getText());
		// // is available
		WebElement we = driver.findElement(btn);
		we.click(); // add to Cart button
	}

	/* 
	 * create Domain name
	 */
	public String CreateDomainName(String domainSpace) {
		// crate date object
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String today = formatter.format( new java.util.Date() );
		// crate unique id
		int unique_num = (int) (Math.random() * 50 + 1);
		String domainName = "takatest" + today + unique_num + domainSpace;

		System.out.println("Domain name =" + domainName);
		return domainName;
	}
}