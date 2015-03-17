package RegisterdomainName;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

import static org.junit.Assert.*;

public class PaymentPage extends Page {

	public void PaybyCredit(WebDriver driver, String baseUrl){
		driver.get(baseUrl + "/cc/order/payment/index");
	    driver.findElement(By.xpath("(//input[@name='eccsid'])[1]")).click();
	    driver.findElement(By.name("cardverificationcode1")).clear();
	    driver.findElement(By.name("cardverificationcode1")).sendKeys("123");
	    driver.findElement(By.id("autorenewal")).click();											// set up auto renewa
	    driver.findElement(By.id("tandc")).click();
	    driver.findElement(By.cssSelector("div.a-button-flexi")).click();
	}

	// Payment manually
	public void paymentmanually(WebDriver driver){
	    driver.findElement(By.id("cc_no")).clear();
	    driver.findElement(By.id("cc_no")).sendKeys("4111111111111111");
		driver.findElement(By.linkText("Month")).click();
		driver.findElement(By.xpath("//li[4]")).click();
	    new Select(driver.findElement(By.id("cc_expiry_month"))).selectByVisibleText("03");
	    driver.findElement(By.xpath("//div[2]/a[2]")).click();
	    driver.findElement(By.xpath("//div[2]/ul/li[6]")).click();
	    driver.findElement(By.id("cc_cvv")).clear();
	    driver.findElement(By.id("cc_cvv")).sendKeys("123");
	    driver.findElement(By.id("cc_name")).clear();
	    driver.findElement(By.id("cc_name")).sendKeys("test");
	    driver.findElement(By.xpath("//form[@id='frmPaymentDetails']/dl/div[2]/label/span")).click();
	    driver.findElement(By.id("submit-order")).click();
	    
	    assertEquals("Thank you for your order", driver.findElement(By.cssSelector("h1")).getText());	    
	}
	
	// Payment simple one
	public void paymentsimple(WebDriver driver){
		driver.findElement(By.name("cardverificationcode1")).clear();
		driver.findElement(By.name("cardverificationcode1")).sendKeys("123");
		driver.findElement(By.id("tandc")).click();
	    driver.findElement(By.id("autorenewal")).click();										// set up auto renewal
		driver.findElement(By.cssSelector("div.a-button-flexi")).click();
		// completed page "Thank you taka!"
	    assertTrue(Pattern.compile("Thank you \\b[a-z0-9!@#$]+\\b").matcher(driver.findElement(By.cssSelector("div.account-pagetitle.rm-left-indent")).getText()).find());
	}
	
	// new payment page
	public void newpayment(WebDriver driver){
		// wait
		try {
			Thread.sleep(5000);	// wait 5 second
		} catch (InterruptedException e) {
			System.out.println("10 second gone!!");
		}

//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By	.id("number")).clear();
	    driver.findElement(By.id("number")).sendKeys("4111111111111111");
	    driver.findElement(By.id("cvv")).clear();
	    driver.findElement(By.id("cvv")).sendKeys("123");
	    new Select(driver.findElement(By.id("expiryMonth"))).selectByVisibleText("07");
	    new Select(driver.findElement(By.id("expiryYear"))).selectByVisibleText("2022");
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys("tester");
	    driver.findElement(By.cssSelector("button.btn.red")).click();
	}
}
