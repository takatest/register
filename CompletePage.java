package RegisterdomainName;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompletePage {
	
	public void CompleteSuccess(WebDriver driver){
    
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.a-button-green")));
		
		if ("Completed".equals(driver.findElement(By.cssSelector("span.redText")).getText()) ||
		"in progress".equals(driver.findElement(By.cssSelector("span.redText")).getText())){
		}else{
			System.out.println("Error!!!");
		}
	}
	
	public void newComplete(WebDriver driver){
	    
		// wait
		try {
			Thread.sleep(30000);	// wait 5 second
		} catch (InterruptedException e) {
			System.out.println("10 second gone!!");
		}
		assertEquals("Order Complete", driver.findElement(By.cssSelector("h1")).getText());
		System.out.println("Payment page end");
	}
}
