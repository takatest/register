package RegisterdomainName;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class PaymentPage extends Page {
	public void PaybyCredit(WebDriver driver, String baseUrl){

//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("paymentFormSection")));

		driver.get(baseUrl + "/cc/order/payment/index");
	    driver.findElement(By.xpath("(//input[@name='eccsid'])[1]")).click();
//	    driver.findElement(By.xpath("//div[2]/div[5]/span/input")).clear();
//	    driver.findElement(By.xpath("//div[2]/div[5]/span/input")).sendKeys("123");

	    driver.findElement(By.name("cardverificationcode1")).clear();
	    driver.findElement(By.name("cardverificationcode1")).sendKeys("123");

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
	  //  new Select(driver.findElement(By.id("cc_expiry_year"))).selectByVisibleText("18");
	    driver.findElement(By.id("cc_cvv")).clear();
	    driver.findElement(By.id("cc_cvv")).sendKeys("123");
	    driver.findElement(By.id("cc_name")).clear();
	    driver.findElement(By.id("cc_name")).sendKeys("test");
	    driver.findElement(By.xpath("//form[@id='frmPaymentDetails']/dl/div[2]/label/span")).click();
	    driver.findElement(By.id("submit-order")).click();
	    assertEquals("Thank you for your order", driver.findElement(By.cssSelector("h1")).getText());	    
	}
}
