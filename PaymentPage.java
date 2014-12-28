package RegisterdomainName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class PaymentPage {
	public void PaybyCredit(WebDriver driver, String baseUrl){

//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("paymentFormSection")));

		driver.get(baseUrl + "/cc/order/payment/index");
	    driver.findElement(By.xpath("(//input[@name='eccsid'])[2]")).click();
	    driver.findElement(By.xpath("//div[2]/div[5]/span/input")).clear();
	    driver.findElement(By.xpath("//div[2]/div[5]/span/input")).sendKeys("123");
	    driver.findElement(By.id("tandc")).click();
	    driver.findElement(By.cssSelector("div.a-button-flexi")).click();
	    
	}
}
