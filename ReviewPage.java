package RegisterdomainName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReviewPage {
	
	public void OneYearOrder(WebDriver driver, String domainName, int year){
		// if AU domain
		if (domainName.indexOf(".com.au") > 0 ||domainName.indexOf(".net.au") > 0 ){
			driver.findElement(By.cssSelector("span.bold-text")).click();
		}else{ // if not au domain
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("selectyear")));
			if ( year == 1){
				driver.findElement(By.xpath("//select/option[text()='1 Year']")).click();
			}else if ( year == 2){															// 2 years
			    driver.findElement(By.xpath("//select/option[text()='2 Years']")).click();
			}else if ( year == 5 ){
				driver.findElement(By.xpath("//select/option[text()='5 Years']")).click();
			}else if ( year == 10 ){
				driver.findElement(By.xpath("//select/option[text()='10 Years']")).click();
			}
			// wait
			try {
				Thread.sleep(5000);	// wait 10 second
			} catch (InterruptedException e) {
				System.out.println("5 second gone!!");
			}
			driver.findElement(By.cssSelector("span.bold-text")).click();
		}
	}
}
