package RegisterdomainName;

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
			System.out.println("Complete page - Match!!!");
		}else{
			System.out.println("Error!!!");
		}
	}
}
